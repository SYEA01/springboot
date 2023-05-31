package com.example.springboot.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")  //监听消息队列，如果有消息，立马执行这个方法，进行消费
    @SendTo("order.other.queue.id")  //可以将当前队列中的消息在处理完这个方法之后，将当前方法的返回值放到另一个队列中
    public String receive(String id) {
        System.out.println("已接收id: " + id);
        return "new: " + id;
    }

}
