//package com.example.springboot.service.impl.activemq;
//
//import com.example.springboot.service.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MessageServiceActivemqImpl implements MessageService {
//
//    @Autowired
//    private JmsMessagingTemplate messagingTemplate;
//
//    @Override
//    public void sendMessage(String id) {
//        System.out.println("id:"+id+"放到队列中");
//        messagingTemplate.convertAndSend("order.queue.id",id);  // 放到消息队列中
//    }
//
//    @Override
//    public String doMessage() {
//        String id = messagingTemplate.receiveAndConvert("order.queue.id",String.class);  //从消息队列中取消息（一般不用这种方法接收消息，都是使用注解@JmsListener自动监听消息）
//        System.out.println("id:" + id + "已经取出");
//        return id;
//    }
//}
