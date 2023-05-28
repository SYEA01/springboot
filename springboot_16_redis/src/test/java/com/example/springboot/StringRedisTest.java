package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class StringRedisTest {

    private RedisTemplate redisTemplate; //对象

    @Autowired
    private StringRedisTemplate stringRedisTemplate;  //字符串

    @Test
    void test(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("taoao","taoao222222");
    }
}
