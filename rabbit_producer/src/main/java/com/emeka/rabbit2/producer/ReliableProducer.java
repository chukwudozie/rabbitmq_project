package com.emeka.rabbit2.producer;

import com.emeka.rabbit2.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

//@Service
public class ReliableProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReliableProducer.class);

    @Autowired
    private RabbitTemplate template;

    @PostConstruct // method is called after spring has initialized rabbit template
    private void registerCallback(){
        // register confirm call back to check exchange validity
        template.setConfirmCallback(((correlationData, ack, cause) -> {
            if(correlationData == null){
                return;
            }
            if(ack){
                LOGGER.info("Message with Correlation {} published", correlationData.getId());
            } else{
                LOGGER.warn("Invalid exchange for message with Correlation {} due to {}", correlationData.getId(),cause);
            }
        }));

        template.setReturnsCallback(returned -> {
            LOGGER.info("Return call back");
            if (returned.getReplyText() != null && returned.getReplyText().equalsIgnoreCase("NO_ROUTE")){
                String id = returned.getMessage().getMessageProperties()
                        .getHeader("spring_returned_message_correlation").toString();
                LOGGER.info("Invalid routing key for message {}",id);
            }
        });

    }

    public void sendDummyWithInvalidRoutingKey(DummyMessage message){
      CorrelationData correlationData =  new CorrelationData(Integer.toString(message.getPublishOrder()));
      template.convertAndSend("x.dummy2","invalid-routing-key",message,correlationData);
    }

    public void sendDummyWithInvalidExchange(DummyMessage message){
        CorrelationData correlationData =  new CorrelationData(Integer.toString(message.getPublishOrder()));
        template.convertAndSend("x.non-exists-exchange","",message,correlationData);
    }
}
