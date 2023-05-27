package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled","false");  // 以更高的优先级关闭热部署。这个优先级比application.properties高
		SpringApplication.run(SSMPApplication.class, args);
	}

}
