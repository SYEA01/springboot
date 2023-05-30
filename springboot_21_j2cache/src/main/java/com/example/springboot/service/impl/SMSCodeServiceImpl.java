package com.example.springboot.service.impl;

import com.example.springboot.domain.SMSCode;
import com.example.springboot.service.SMSCodeService;
import com.example.springboot.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;  //缓存对象

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms", tele, code);  //放入缓存
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存中的与传进来的比对
        String code = smsCode.getCode();
        String queryCode = cacheChannel.get("sms",smsCode.getTele()).asString();  //从缓存取出
        return code.equals(queryCode);
    }


}
