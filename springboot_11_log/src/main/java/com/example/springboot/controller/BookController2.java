package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books2")
@Slf4j  //使用这个注解可以替代  private static final Logger log = LoggerFactory.getLogger(BookController2.class);
public class BookController2 {

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
