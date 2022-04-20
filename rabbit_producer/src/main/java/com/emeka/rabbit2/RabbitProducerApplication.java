package com.emeka.rabbit2;

import com.emeka.rabbit2.entity.DummyMessage;
import com.emeka.rabbit2.entity.InvoiceCancelledMessage;
import com.emeka.rabbit2.entity.InvoiceCreatedMessage;
import com.emeka.rabbit2.entity.InvoicePaidMessage;
import com.emeka.rabbit2.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RabbitProducerApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }
    @Autowired
//    private MultiplePrefetchProducer producer;
//    private InvoiceProducer producer;
//    private SingleActiveProducer producer;
//    private ReliableProducer producer;
    private AnotherDummyProducer producer;

//    @Override
//    public void run(String... args) throws Exception {
////        for(int i = 0; i < 500; i++) {
////            DummyMessage message = new DummyMessage("Now is " + LocalTime.now(), 1);
////            producer.sendDummy(message);
////            TimeUnit.SECONDS.sleep(1);
////        producer.simulateTransaction();
////        producer.simulateScheduler();
////        }
//       String randomInvoiceNumber =  "INV-"+ ThreadLocalRandom.current().nextInt(100,200);
//
//        InvoiceCreatedMessage invoiceCreatedMessage =
//         new InvoiceCreatedMessage(150.0, LocalDate.now().minusDays(2),"USD",randomInvoiceNumber);
//        producer.sendInvoiceCreated(invoiceCreatedMessage);
//        randomInvoiceNumber =  "INV-"+ ThreadLocalRandom.current().nextInt(200,300);
//        String randomPaymentNumber =  "INV-"+ ThreadLocalRandom.current().nextInt(800,1000);
//        InvoicePaidMessage invoicePaidMessage =
//                new InvoicePaidMessage(randomInvoiceNumber,LocalDate.now(),randomPaymentNumber);
//        producer.sendInvoicePaid(invoicePaidMessage);
//
//        randomInvoiceNumber =  "INV-"+ ThreadLocalRandom.current().nextInt(300,400);
//        InvoiceCancelledMessage invoiceCancelledMessage =
//                new InvoiceCancelledMessage(LocalDate.now(),randomInvoiceNumber, "testing ...");
//        producer.sendInvoiceCancelled(invoiceCancelledMessage);
//        System.out.println("All sent");
//    }

    // for demonstrating consistent hash exchange
//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++){
//            String invoiceNumber = "INV-"+ i;
//            InvoiceCancelledMessage invoice = new InvoiceCancelledMessage(LocalDate.now(),
//                    invoiceNumber, "Test"+i);
//            producer.sendInvoiceCancelled(invoice);
////            System.out.println("done");
//        }
////        producer.sendDummy(); // for SAC
////        DummyMessage dummy1 = new DummyMessage("Invalid key",10);
////        DummyMessage dummy2 = new DummyMessage("Invalid exchange", 20);
////        producer.sendDummyWithInvalidRoutingKey(dummy1);
////        producer.sendDummyWithInvalidExchange(dummy2);
////        System.out.println("done");
//    }

    // For practicing queues and exchange creation using Java codes
    @Override
    public void run(String... args) throws Exception {
        DummyMessage message = new DummyMessage("a dummy message", 1);
        producer.sendDummy(message);

    }


}
