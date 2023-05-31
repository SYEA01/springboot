package com.example.springboot.service.impl.rabbit.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class MessageListener {
//    @RabbitListener(queues = "direct_queue")  //作用和ActiveMQ的@JmsListener注解类似
    public void receive(String id) {
        System.out.println("已接收到消息，id = " + id);
    }
}
