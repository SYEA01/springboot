package com.example.springboot.service.impl;

import com.example.springboot.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageServiceImpl implements MessageService {
    private ArrayList<String> msgList = new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("id:"+id+"放到队列中");
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("id:" + id + "已经取出");
        return id;
    }
}
