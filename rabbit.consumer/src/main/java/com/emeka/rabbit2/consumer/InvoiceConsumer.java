package com.emeka.rabbit2.consumer;

import com.emeka.rabbit2.entity.InvoiceCancelledMessage;
import com.emeka.rabbit2.entity.InvoiceCreatedMessage;
import com.emeka.rabbit2.entity.InvoicePaidMessage;
import com.emeka.rabbit2.entity.PaymentCancelStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

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

    @RabbitHandler
    @SendTo("x.invoice.cancel/") // specify the routing key if exchange is not fanout
    public PaymentCancelStatus handleInvoiceCancelled(InvoiceCancelledMessage message){
        boolean randomStatus = ThreadLocalRandom.current().nextBoolean();
        return new PaymentCancelStatus(randomStatus,LocalDate.now(), message.getInvoiceNumber());
    }
}

