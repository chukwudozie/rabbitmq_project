package com.emeka.rabbit2.producer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotherDummyProducer {

    @Autowired
    // this template internally uses the Jackson2Json converter bean created
    // No Object mapper is used for serialization
    private RabbitTemplate template;

    /**
     * This method sends or publishes a dummy message
     * @param message is the dummy message won't be converted to JSON string
     *Jackson2Json converter will do that internally
     */
    public void sendDummy (DummyMessage message){
        // directly convert and send message to the exchange
        template.convertAndSend("x.another-dummy","",message);


    }
}
