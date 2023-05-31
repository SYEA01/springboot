package com.example.springboot.service;

public interface MessageService {

    //把要发送消息的id放到消息队列
    void sendMessage(String id);

    //从消息队列取出id
    String doMessage();
}
