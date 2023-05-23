package com.example.springboot.controller;

import com.example.springboot.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    /**
     * 读取yml中的单个数据
     */
    @Value("${country}")
    private String coun;

    /**
     * 读取yml中的全部数据
     * 使用自动装配将所有的数据封装到对象Environment中
     */
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource dataSource;

    @GetMapping
    public String getById() {
        System.out.println("coun = " + coun);
        System.out.println("===================================================");
        System.out.println("env.getProperty(\"country\") = " + env.getProperty("country"));
        System.out.println("------------------------------------------------------");
        System.out.println("dataSource = " + dataSource);
        System.out.println("SpringBoot is running");
        return "SpringBoot is running...";
    }
}
