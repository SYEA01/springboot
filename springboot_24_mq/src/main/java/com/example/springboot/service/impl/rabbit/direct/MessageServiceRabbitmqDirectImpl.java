package com.example.springboot.service.impl.rabbit.direct;

import com.example.springboot.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//使用直连交换机
@Service
public class MessageServiceRabbitmqDirectImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("id:" + id + "放到队列中");
        amqpTemplate.convertAndSend("directExchange", "direct", id);  // 交换机名称，routingKey，消息
    }

    @Override
    public String doMessage() {
        return null;
    }
}
