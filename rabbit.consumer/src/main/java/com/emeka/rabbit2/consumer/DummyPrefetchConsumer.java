package com.emeka.rabbit2.consumer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class DummyPrefetchConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyConsumer.class);

    /**
     *
     * @param message is an object of the DummyMessage class
     * Unlike before, the listener class takes an object instead of a string
     * This is because the Jackson2Json converter handles the deserialization
     */
    @RabbitListener(queues = "q.dummy", concurrency = "2")
    private void listen(DummyMessage message) throws InterruptedException {
        LOGGER.info("Message is : {}",message);
        TimeUnit.SECONDS.sleep(20);

    }
}
