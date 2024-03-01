package demo.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DltHandler {

    public void dlt(String data, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.error("Event from topic " + topic + " is dead lettered - event:" + data);
    }

}
