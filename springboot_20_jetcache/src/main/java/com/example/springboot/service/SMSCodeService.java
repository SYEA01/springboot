package com.example.springboot.service;

import com.example.springboot.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String tele);
    boolean checkCode(SMSCode smsCode);
}
