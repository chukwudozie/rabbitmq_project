package com.emeka.rabbit2.consumer;

import com.emeka.rabbit2.entity.InvoiceCreatedMessage;
import com.emeka.rabbit2.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message){
        LOGGER.info("Invoice Created: {}",message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message){
        LOGGER.info("Invoice Paid: {}",message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message){
        LOGGER.warn("Handling Default: {}",message);
    }
}

