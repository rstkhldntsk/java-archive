package demo.retry;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.retrytopic.RetryTopicComponentFactory;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class MyRetryTopicConfigurationSupport extends RetryTopicConfigurationSupport {

    @Override
    protected RetryTopicComponentFactory createComponentFactory() {
        return new MyRetryTopicComponentFactory();
    }

}
