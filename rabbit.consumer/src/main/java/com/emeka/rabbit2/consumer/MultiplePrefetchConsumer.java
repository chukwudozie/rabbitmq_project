package com.emeka.rabbit2.consumer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class MultiplePrefetchConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiplePrefetchConsumer.class);

    @RabbitListener(queues = "q.transaction", concurrency = "2")
    public void listenTransaction(DummyMessage message) throws InterruptedException {
        LOGGER.info("Taking transaction: {}",message);
        TimeUnit.MILLISECONDS.sleep(100);
    }

    @RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
    public void listenScheduler(DummyMessage message) throws InterruptedException {
        LOGGER.info("Taking scheduler: {}",message);
        TimeUnit.MINUTES.sleep(1);
    }
}
