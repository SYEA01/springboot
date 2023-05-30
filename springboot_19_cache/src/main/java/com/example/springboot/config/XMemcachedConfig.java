package com.example.springboot.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties xMemcachedProperties;
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        memcachedClientBuilder.setOpTimeout(xMemcachedProperties.getTimeOut());
        memcachedClientBuilder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        MemcachedClient memcachedClient = memcachedClientBuilder.build();
        return memcachedClient;
    }
}
