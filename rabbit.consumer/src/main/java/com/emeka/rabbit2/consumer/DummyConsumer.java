package com.emeka.rabbit2.consumer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class DummyConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyConsumer.class);

    /**
     *
     * @param message is an object of the DummyMessage class
     * Unlike before, the listener class takes an object instead of a string
     * This is because the Jackson2Json converter handles the deserialization
     */
    @RabbitListener(queues = "q.dummy")
    private void listen(DummyMessage message){
        LOGGER.info("Message is : {}",message);

    }
}
