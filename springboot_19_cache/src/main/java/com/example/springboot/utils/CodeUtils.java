package com.example.springboot.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {
    private String[] patch = {"00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        int hash = tele.hashCode();
        int encryption = 20234444;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = String.valueOf(code);
        int len = codeStr.length();
        return patch[len-1] + codeStr;
    }

    @Cacheable(value = "smsCode",key = "#tele")
    public String get(String tele) {
        return null;
    }
}
