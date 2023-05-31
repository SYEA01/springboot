package com.example.springboot.service.impl.rocketmq;

import com.example.springboot.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceRocketmqImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("生产消息，id： " + id);
//        rocketMQTemplate.convertAndSend("order_id", id);  // 生产消息（这一行的写法是同步消息，正常情况应该使用异步消息）
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // 异步消息发送成功的回调处理
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                // 异步消息发送异常的回调处理
                System.out.println("消息发送失败！");
            }
        };
        rocketMQTemplate.asyncSend("order_id",id,callback);  //异步消息.三个参数：消息存放的位置、消息、以及消息成功或失败应该怎么处理
    }

    @Override
    public String doMessage() {
        return null;
    }
}
