package com.example.springboot;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation  // jetCache的注解。是jetcache启用缓存的主开关   启用使用注解方式创建缓存
@EnableMethodCache(basePackages = "com.example.springboot")  //开启方法注解缓存
public class Springboot20JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot20JetcacheApplication.class, args);
    }

}
