package com.example.springboot.controller;

import com.example.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{id}")
    public void order(@PathVariable String id) {
        orderService.order(id);
    }
}
