package com.example.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
@Data
@ConfigurationProperties(prefix = "servers")
public class ServerConfig {
    private String ipAddress;
    private int port;
    private long timeout;

    @DurationUnit(ChronoUnit.HOURS)  // 代表以小时为单位
    private Duration serverTimeOut;  // PT3H

    @DataSizeUnit(DataUnit.BYTES)  // 数据存储单位  代表byte
    private DataSize dataSize;  // 10B
}
