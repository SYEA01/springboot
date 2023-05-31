//package com.example.springboot.service.impl.rabbit.topic.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitConfigTopic {
//
//    @Bean
//    public Queue topicQueue(){
//        return new Queue("topic_queue");
//    }
//
//    @Bean
//    public Queue topicQueue2(){
//        return new Queue("topic_queue2");
//    }
//
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange("topicExchange");
//    }
//
//    @Bean
//    public Binding binding(){
//        return BindingBuilder.bind(topicQueue()).to(exchange())
//                .with("topic.*.ids");  // 模糊匹配，以topic开头的，ids结尾
//    }
//
//    @Bean
//    public Binding binding2(){
//        return BindingBuilder.bind(topicQueue2()).to(exchange())
//                .with("topic2");
//    }
//
//}
