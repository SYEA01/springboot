package com.example.springboot.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @KafkaListener(topics = "topic1")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("消费消息，id：   " + record.value());
    }
}
