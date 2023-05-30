package com.example.springboot;

import com.example.springboot.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot23MailApplicationTests {

    @Autowired
    private SendMailService sendMailService;
    @Test
    void contextLoads() {
        sendMailService.sendMail();
    }

}
