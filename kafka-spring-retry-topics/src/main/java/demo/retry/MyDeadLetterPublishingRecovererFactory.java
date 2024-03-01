package demo.retry;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.springframework.core.NestedRuntimeException;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekUtils;
import org.springframework.kafka.listener.TimestampedException;
import org.springframework.kafka.retrytopic.DeadLetterPublishingRecovererFactory;
import org.springframework.kafka.retrytopic.DestinationTopic;
import org.springframework.kafka.retrytopic.DestinationTopicResolver;
import org.springframework.kafka.retrytopic.RetryTopicHeaders;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class MyDeadLetterPublishingRecovererFactory extends DeadLetterPublishingRecovererFactory {

    private final DestinationTopicResolver destinationTopicResolver;
    private final Set<Class<? extends Exception>> fatalExceptions = new LinkedHashSet<>();
    private final Set<Class<? extends Exception>> nonFatalExceptions = new HashSet<>();
    private ListenerExceptionLoggingStrategy loggingStrategy = ListenerExceptionLoggingStrategy.AFTER_RETRIES_EXHAUSTED;
    private Consumer<DeadLetterPublishingRecoverer> recovererCustomizer = recoverer -> {
    };

    public MyDeadLetterPublishingRecovererFactory(DestinationTopicResolver destinationTopicResolver) {
        super(destinationTopicResolver);
        this.destinationTopicResolver = destinationTopicResolver;
    }

    @Override
    public DeadLetterPublishingRecoverer create(String mainListenerId) {
        Assert.notNull(mainListenerId, "'listenerId' cannot be null");
        DeadLetterPublishingRecoverer recoverer = new MyDeadLetterRecoverer(templateResolver(mainListenerId), false, destinationResolver(mainListenerId)) {

            @Override
            protected HeaderNames getHeaderNames() {
                return HeaderNames.Builder.original().offsetHeader(KafkaHeaders.ORIGINAL_OFFSET).timestampHeader(KafkaHeaders.ORIGINAL_TIMESTAMP).timestampTypeHeader(KafkaHeaders.ORIGINAL_TIMESTAMP_TYPE).topicHeader(KafkaHeaders.ORIGINAL_TOPIC).partitionHeader(KafkaHeaders.ORIGINAL_PARTITION).consumerGroupHeader(KafkaHeaders.ORIGINAL_CONSUMER_GROUP).exception().keyExceptionFqcn(KafkaHeaders.KEY_EXCEPTION_FQCN).exceptionFqcn(KafkaHeaders.EXCEPTION_FQCN).exceptionCauseFqcn(KafkaHeaders.EXCEPTION_CAUSE_FQCN).keyExceptionMessage(KafkaHeaders.KEY_EXCEPTION_MESSAGE).exceptionMessage(KafkaHeaders.EXCEPTION_MESSAGE).keyExceptionStacktrace(KafkaHeaders.KEY_EXCEPTION_STACKTRACE).exceptionStacktrace(KafkaHeaders.EXCEPTION_STACKTRACE).build();
            }
        };

        recoverer.setHeadersFunction((consumerRecord, e) -> addHeaders(mainListenerId, consumerRecord, e, getAttempts(consumerRecord)));

        recoverer.setFailIfSendResultIsError(true);
        recoverer.setAppendOriginalHeaders(false);
        recoverer.setThrowIfNoDestinationReturned(false);
        recoverer.setSkipSameTopicFatalExceptions(false);
        this.recovererCustomizer.accept(recoverer);
        this.fatalExceptions.forEach(recoverer::addNotRetryableExceptions);
        this.nonFatalExceptions.forEach(recoverer::removeClassification);
        return recoverer;
    }

    private Headers addHeaders(String mainListenerId, ConsumerRecord<?, ?> consumerRecord, Exception e, int attempts) {
        Headers headers = new RecordHeaders();
        byte[] originalTimestampHeader = getOriginalTimestampHeaderBytes(consumerRecord);
        headers.add(RetryTopicHeaders.DEFAULT_HEADER_ORIGINAL_TIMESTAMP, originalTimestampHeader);
        headers.add(RetryTopicHeaders.DEFAULT_HEADER_ATTEMPTS, ByteBuffer.wrap(new byte[Integer.BYTES]).putInt(attempts + 1).array());
        headers.add(RetryTopicHeaders.DEFAULT_HEADER_BACKOFF_TIMESTAMP, BigInteger.valueOf(getNextExecutionTimestamp(mainListenerId, consumerRecord, e, originalTimestampHeader)).toByteArray());
        return headers;
    }

    private long getNextExecutionTimestamp(String mainListenerId, ConsumerRecord<?, ?> consumerRecord, Exception e, byte[] originalTimestampHeader) {
        long originalTimestamp = new BigInteger(originalTimestampHeader).longValue();
        long failureTimestamp = getFailureTimestamp(e);
        long nextExecutionTimestamp = failureTimestamp + this.destinationTopicResolver.resolveDestinationTopic(mainListenerId, consumerRecord.topic(), getAttempts(consumerRecord), e, originalTimestamp).getDestinationDelay();
        log.debug(String.format("FailureTimestamp: %s, Original timestamp: %s, nextExecutionTimestamp: %s", failureTimestamp, originalTimestamp, nextExecutionTimestamp));
        return nextExecutionTimestamp;
    }

    private int getAttempts(ConsumerRecord<?, ?> consumerRecord) {
        Header header = consumerRecord.headers().lastHeader(RetryTopicHeaders.DEFAULT_HEADER_ATTEMPTS);
        if (header != null) {
            byte[] value = header.value();
            if (value.length == Byte.BYTES) { // backwards compatibility
                return value[0];
            } else if (value.length == Integer.BYTES) {
                return ByteBuffer.wrap(value).getInt();
            } else {
                log.debug("Unexected size for " + RetryTopicHeaders.DEFAULT_HEADER_ATTEMPTS + " header: " + value.length);
            }
        }
        return 1;
    }

    private long getFailureTimestamp(Exception e) {
        return e instanceof NestedRuntimeException && ((NestedRuntimeException) e).contains(TimestampedException.class) ? getTimestampedException(e).getTimestamp() : Instant.now().toEpochMilli();
    }

    private TimestampedException getTimestampedException(@Nullable Throwable e) {
        if (e == null) {
            throw new IllegalArgumentException("Provided exception does not contain a " + TimestampedException.class.getSimpleName() + " cause.");
        }
        return e.getClass().isAssignableFrom(TimestampedException.class) ? (TimestampedException) e : getTimestampedException(e.getCause());
    }

    private byte[] getOriginalTimestampHeaderBytes(ConsumerRecord<?, ?> consumerRecord) {
        Header currentOriginalTimestampHeader = getOriginaTimeStampHeader(consumerRecord);
        return currentOriginalTimestampHeader != null ? currentOriginalTimestampHeader.value() : BigInteger.valueOf(consumerRecord.timestamp()).toByteArray();
    }

    @Nullable
    private Header getOriginaTimeStampHeader(ConsumerRecord<?, ?> consumerRecord) {
        return consumerRecord.headers().lastHeader(RetryTopicHeaders.DEFAULT_HEADER_ORIGINAL_TIMESTAMP);
    }

    private Function<ProducerRecord<?, ?>, KafkaOperations<?, ?>> templateResolver(String mainListenerId) {
        return outRecord -> this.destinationTopicResolver.getDestinationTopicByName(mainListenerId, outRecord.topic()).getKafkaOperations();
    }

    private BiFunction<ConsumerRecord<?, ?>, Exception, TopicPartition> destinationResolver(String mainListenerId) {
        return (cr, ex) -> {
            if (SeekUtils.isBackoffException(ex)) {
                throw (NestedRuntimeException) ex; // Necessary to not commit the offset and seek to current again
            }

            DestinationTopic nextDestination = this.destinationTopicResolver.resolveDestinationTopic(mainListenerId, cr.topic(), getAttempts(cr), ex, getOriginalTimestampHeaderLong(cr));

            log.debug("Resolved topic: " + (nextDestination.isNoOpsTopic() ? "none" : nextDestination.getDestinationName()));

            maybeLogListenerException(ex, cr, nextDestination);

            return nextDestination.isNoOpsTopic() ? null : resolveTopicPartition(cr, nextDestination);
        };
    }

    private void maybeLogListenerException(Exception e, ConsumerRecord<?, ?> cr, DestinationTopic nextDestination) {
        if (nextDestination.isDltTopic() && !ListenerExceptionLoggingStrategy.NEVER.equals(this.loggingStrategy)) {
            log.error(getErrorMessage(cr) + " and won't be retried. " + "Sending to DLT with name " + nextDestination.getDestinationName() + ".");
        } else if (nextDestination.isNoOpsTopic() && !ListenerExceptionLoggingStrategy.NEVER.equals(this.loggingStrategy)) {
            log.error(getErrorMessage(cr) + " and won't be retried. " + "No further action will be taken with this record.");
        } else if (ListenerExceptionLoggingStrategy.EACH_ATTEMPT.equals(this.loggingStrategy)) {
            log.error(getErrorMessage(cr) + ". " + "Sending to retry topic " + nextDestination.getDestinationName() + ".");
        } else {
            log.debug(getErrorMessage(cr) + ". " + "Sending to retry topic " + nextDestination.getDestinationName() + ".");
        }
    }

    private static String getErrorMessage(ConsumerRecord<?, ?> cr) {
        return "Record: " + getRecordInfo(cr) + " threw an error at topic " + cr.topic();
    }

    private static String getRecordInfo(ConsumerRecord<?, ?> cr) {
        Header originalTopicHeader = cr.headers().lastHeader(KafkaHeaders.ORIGINAL_TOPIC);
        return String.format("topic = %s, partition = %s, offset = %s, main topic = %s", cr.topic(), cr.partition(), cr.offset(), originalTopicHeader != null ? new String(originalTopicHeader.value()) : cr.topic());
    }

    private long getOriginalTimestampHeaderLong(ConsumerRecord<?, ?> consumerRecord) {
        Header currentOriginalTimestampHeader = getOriginaTimeStampHeader(consumerRecord);
        return currentOriginalTimestampHeader != null ? new BigInteger(currentOriginalTimestampHeader.value()).longValue() : consumerRecord.timestamp();
    }

    private enum ListenerExceptionLoggingStrategy {

        /**
         * Never log the listener exception.
         */
        NEVER,

        /**
         * Log the listener exception after each attempt.
         */
        EACH_ATTEMPT,

        /**
         * Log the listener only after retries are exhausted.
         */
        AFTER_RETRIES_EXHAUSTED

    }

}
