package com.emeka.rabbit2.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

//    @Bean
//    /**
//     *  This is the method we can use to create a fanout exchange from the Java project
//     *   Rather than using the RabbitMq admin console
//     *   there is standard class for creating the basic non-plugin exchange types
//     */
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange("x.another-dummy",true,false, null);
//    }
//
////    @Bean
////    public TopicExchange topicExchange(){
////        return new TopicExchange("x.another-topic",true,false,null);
////    }
//
//    /**
//     * This method provides custom code for creating a queue on rabbit MQ from the Java project
//     * Rather than from the Rabbit Mq admin console
//     */
//    @Bean
//    public Queue queueAnotherDummy(){
//        return new Queue("q.another-dummy");
//    }
//
//    /**
//     * This method provides custom code for binding a custom exchange to a queue
//     * The destination is the queue you are binding.
//     * The Destination type is Queue
//     */
//    @Bean
//    public Binding bindingAnotherDummy (){
//        // First Method: Using an object of the Binding class
////        return new Binding("q.another-dummy", DestinationType.QUEUE,
////                "x.another-dummy",null, null);
//
//        // Second Method: Using the helper class; BindingBuilder and calling its static methods
//        return BindingBuilder.bind(queueAnotherDummy()).to(fanoutExchange());
//    }

    /**
     *Instead of Creating our queue, exchange and bindings separately, we can use Declarables
     * TO create all at once
     */
    @Bean
    public Declarables rabbitmqSchema(){
        return new Declarables(
                new FanoutExchange("x.another-dummy",true,false),
                new Queue("q.another-dummy"),
                new Binding("q.another-dummy", DestinationType.QUEUE,
                "x.another-dummy","", null)

        );
    }

}
