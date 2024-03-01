package demo.retry;

import lombok.AllArgsConstructor;
import org.springframework.kafka.retrytopic.DeadLetterPublishingRecovererFactory;
import org.springframework.kafka.retrytopic.DestinationTopicResolver;
import org.springframework.kafka.retrytopic.RetryTopicComponentFactory;

@AllArgsConstructor
public class MyRetryTopicComponentFactory extends RetryTopicComponentFactory {

    @Override
    public DeadLetterPublishingRecovererFactory deadLetterPublishingRecovererFactory(DestinationTopicResolver destinationTopicResolver) {
        return new MyDeadLetterPublishingRecovererFactory(destinationTopicResolver);
    }

}
