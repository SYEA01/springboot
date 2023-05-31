//package com.example.springboot.service.impl.rocketmq.listener;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RocketMQMessageListener(topic = "order_id",consumerGroup = "group_rocketmq")  //至少必须指定这两个参数
//public class MessageListener implements RocketMQListener<String> {
//
//
//    @Override
//    public void onMessage(String id) {
//        System.out.println("消费消息，id：    " + id);
//    }
//}
