package com.example.springboot.controller;

import com.example.springboot.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
//    @PostMapping("/users")
//    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
//        // 处理用户创建逻辑
//        return ResponseEntity.ok("User created successfully");
//    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 处理验证错误
            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getFieldError().getDefaultMessage());
        }
        // 处理用户创建逻辑
        return ResponseEntity.ok("User created successfully");
    }
}