package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MsgConfig {

    // 一个String类型的bean
    @Bean
    public String msg(){
        return "bean msg";
    }

}
