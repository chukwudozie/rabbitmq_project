package com.emeka.rabbit2.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RabbitmqScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqScheduler.class);

    // This enables us to get all the rabbit listeners created
    @Autowired
    private RabbitListenerEndpointRegistry registry;

    // Method to stop all listeners by 11 pm using the scheduler
//    @Scheduled(cron = "0 0 23 * * *")
    @Scheduled(cron = "0 11 7 * * *")
    public void stopAll(){
        registry.getListenerContainers().forEach(c -> {
            LOGGER.info("Stopping listener container : {}",c);
            c.stop();
        });
    }

    // Method to start all listeners, 1 sec after midnight
//    @Scheduled(cron = "1 0 0 * * *") // cron(sec min hour )
    @Scheduled(cron = "0 10 7 * * *")
    public void startAll(){
        registry.getListenerContainers().forEach(c -> {
            LOGGER.info("Stopping listener container : {}",c);
            c.start();
        });
    }
}
