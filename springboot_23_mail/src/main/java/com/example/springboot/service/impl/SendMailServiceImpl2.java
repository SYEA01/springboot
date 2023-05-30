package com.example.springboot.service.impl;

import com.example.springboot.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl2 implements SendMailService {

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
    private String context = "<a href='https://syea01.github.io/'> 点开有惊喜 </a>";

    @Override
    public void sendMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from + "(小甜甜)");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(context);



        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);  // true 代表允许添加附件
            helper.setFrom(from + "(小甜甜)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);  // 发送正文带链接的话，需要指定html=true

            //发送附件
            File f1 = new File("E:\\sourceCode\\java_code\\springboot\\springboot_01_04_quickstart\\pom.xml");
            File f2 = new File("F:\\壁纸.jpg");
            helper.addAttachment("pom.xml",f1);
            helper.addAttachment("壁纸.jpg",f2);

            javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
