package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController extends BaseClass {

    //创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String hello() {
        System.out.println("springboot ........");

        //使用
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error.....");
        return "hello...";
    }
}
