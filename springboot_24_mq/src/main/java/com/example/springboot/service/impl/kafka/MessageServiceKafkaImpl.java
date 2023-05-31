package com.example.springboot.service.impl.kafka;

import com.example.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceKafkaImpl implements MessageService {


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("生产消息：id：  " + id);
        kafkaTemplate.send("topic1",id);  //生产消息
    }

    @Override
    public String doMessage() {
        return null;
    }
}
