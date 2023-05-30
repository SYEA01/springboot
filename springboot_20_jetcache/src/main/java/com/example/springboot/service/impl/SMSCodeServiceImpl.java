package com.example.springboot.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.springboot.domain.SMSCode;
import com.example.springboot.service.SMSCodeService;
import com.example.springboot.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    // 自定义缓存空间  import com.alicp.jetcache.Cache;

    /**
     * @CreateCache(name = "jetCache",expire = 3600,timeUnit = TimeUnit.SECONDS)：远程的方案。告诉jetCache 这是一个用来缓存的对象。
     * 这个name等同于@Cacheable注解的value；
     * expire 指定过期时间；
     * timeUnit = TimeUnit.SECONDS 单位默认是秒，这就是默认值
     * cacheType   有三种选择：只用远程、只用本地、两者都用.默认只用远程
     * area:  就是remote或者local下面的属性名，默认时default
     */
    @CreateCache(area="default",name = "jetCache",expire = 3600,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String,String> jetCache;
    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele,code);  // 放入缓存
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //取出内存中的与传进来的比对
        String code = smsCode.getCode();
        String queryCode = jetCache.get(smsCode.getTele());  // 从缓存中取出
        return code.equals(queryCode);
    }


}
