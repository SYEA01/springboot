package com.example.springboot.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Scheduled(cron = "0/3 * * * * ?")  //每3秒执行一次
    public void print() {
        System.out.println(Thread.currentThread().getName() + "spring task .......");
    }
}
