package com.example.springboot.controller;

import com.example.springboot.domain.SMSCode;
import com.example.springboot.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService service;

    @GetMapping
    public String getCode(String tele){
        String code = service.sendCOdeToSMS(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode){
        return service.checkCode(smsCode);
    }
}
