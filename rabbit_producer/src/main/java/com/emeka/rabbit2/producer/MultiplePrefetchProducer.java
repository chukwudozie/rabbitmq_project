package com.emeka.rabbit2.producer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

//@Service
public class MultiplePrefetchProducer {
    @Autowired
    private RabbitTemplate template;

    public void simulateTransaction(){
        for(int i = 0; i < 2000; i++){
            DummyMessage message = new DummyMessage("Transaction "+ LocalTime.now(),i);
            template.convertAndSend("x.transaction","",message);
        }
    }

    public void simulateScheduler(){
        for(int i = 0; i < 100; i++){
            DummyMessage message = new DummyMessage("Scheduler "+ LocalTime.now(),i);
            template.convertAndSend("x.scheduler","",message);
        }
    }
}
