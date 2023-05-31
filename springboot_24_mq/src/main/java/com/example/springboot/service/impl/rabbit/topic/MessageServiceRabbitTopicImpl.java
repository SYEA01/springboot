//package com.example.springboot.service.impl.rabbit.topic;
//
//import com.example.springboot.service.MessageService;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageServiceRabbitTopicImpl implements MessageService {
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("生产消息，id：  " + id);
//        amqpTemplate.convertAndSend("topicExchange", "topic.abc.id", id);
//    }
//
//    @Override
//    public String doMessage() {
//        return null;
//    }
//}
