package com.example.springboot.service.impl;

import com.example.springboot.domain.SMSCode;
import com.example.springboot.service.SMSCodeService;
import com.example.springboot.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
    @CachePut(value = "smsCode",key = "#tele")
    public String sendCOdeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存中的与传进来的比对
        String code = smsCode.getCode();
        String cacheCode =codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }


}
