package com.example.springboot.controller;

import com.example.springboot.domain.Book;
import com.example.springboot.service.BookService;
import com.example.springboot.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @PostMapping
    public Boolean check(String tele,String code) {
        return msgService.check(tele,code);
    }

    @GetMapping("/{tele}")
    public String get(@PathVariable String tele) {
        return msgService.get(tele);
    }
}
