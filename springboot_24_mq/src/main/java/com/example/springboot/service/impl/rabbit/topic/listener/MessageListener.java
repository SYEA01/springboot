//package com.example.springboot.service.impl.rabbit.topic.listener;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageListener {
//
//    @RabbitListener(queues = "topic_queue")
//    public void listener(String id) {
//        System.out.println("消费消息1，id： " + id);
//    }
//
//    @RabbitListener(queues = "topic_queue2")
//    public void listener2(String id) {
//        System.out.println("消费消息2222222222，id： " + id);
//    }
//}
