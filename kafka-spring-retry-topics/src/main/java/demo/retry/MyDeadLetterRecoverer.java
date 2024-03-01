package demo.retry;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.support.KafkaUtils;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
public class MyDeadLetterRecoverer extends DeadLetterPublishingRecoverer {

    public MyDeadLetterRecoverer(Function<ProducerRecord<?, ?>, KafkaOperations<?, ?>> templateResolver,
                                 boolean transactional,
                                 BiFunction<ConsumerRecord<?, ?>, Exception,
                                         TopicPartition> destinationResolver) {
        super(templateResolver, transactional, destinationResolver);
    }

    @Override
    protected void publish(ProducerRecord<Object, Object> outRecord, KafkaOperations<Object, Object> kafkaTemplate, ConsumerRecord<?, ?> inRecord) {
        log.error("SIEMANKO");
        CompletableFuture<SendResult<Object, Object>> sendResult = null;
        try {
            sendResult = kafkaTemplate.send(outRecord);
            sendResult.whenComplete((result, ex) -> {
                if (ex == null) {
                    this.logger.debug(() -> "Successful dead-letter publication: "
                            + KafkaUtils.format(inRecord) + " to " + result.getRecordMetadata());
                } else {
                    this.logger.error(ex, () -> pubFailMessage(outRecord, inRecord));
                }
            });
        } catch (Exception e) {
            this.logger.error(e, () -> pubFailMessage(outRecord, inRecord));
        }
    }

    private String pubFailMessage(ProducerRecord<Object, Object> outRecord, ConsumerRecord<?, ?> inRecord) {
        return "Dead-letter publication to "
                + outRecord.topic() + " failed for: " + KafkaUtils.format(inRecord);
    }

}
