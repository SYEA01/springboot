package com.example.springboot.service.impl;

import com.example.springboot.domain.SMSCode;
import com.example.springboot.service.SMSCodeService;
import com.example.springboot.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @Override
//    @CachePut(value = "smsCode",key = "#tele")
//    public String sendCOdeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        //取出内存中的与传进来的比对
//        String code = smsCode.getCode();
//        String cacheCode =codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }


    // 以下是SpringBoot中使用xmemcached

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCOdeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele, 10, code);  // 三个参数：需要放到缓存中的key，过期时间，值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存中的与传进来的比对
        String code = smsCode.getCode();
        String cacheCode = null;
        try {
            cacheCode = memcachedClient.get(smsCode.getTele());  // 从缓存中取出
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code.equals(cacheCode);
    }

}
