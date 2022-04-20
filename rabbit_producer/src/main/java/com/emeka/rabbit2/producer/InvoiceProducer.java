package com.emeka.rabbit2.producer;

import com.emeka.rabbit2.entity.InvoiceCancelledMessage;
import com.emeka.rabbit2.entity.InvoiceCreatedMessage;
import com.emeka.rabbit2.entity.InvoicePaidMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private static final String EXCHANGE = "x.invoice";

	public void sendInvoiceCreated(InvoiceCreatedMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, "", message);
	}

	public void sendInvoicePaid(InvoicePaidMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, "", message);
	}

	public void sendInvoiceCancelled(InvoiceCancelledMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
	}

}