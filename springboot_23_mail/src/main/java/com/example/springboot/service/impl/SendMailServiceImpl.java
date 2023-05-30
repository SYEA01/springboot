package com.example.springboot.service.impl;

import com.example.springboot.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
public class SendMailServiceImpl implements SendMailService {

    //1、自动装配javaMailSender
    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "toaoa0101@163.com";
    //接收人
    private String to = "1847530863@qq.com";

    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "测试邮件正文内容";

    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + "(小甜甜)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
