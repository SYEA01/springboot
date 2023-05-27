package com.example.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springboot.config.ServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})  //开启属性绑定，并设定对应的bean。如果设置了这个注解，就不需要在对应的类上加上@Component这个注解了
public class Springboot13ConfigurationApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource dataSource(){
		DruidDataSource ds = new DruidDataSource();
		return ds;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
		ServerConfig bean = ctx.getBean(ServerConfig.class);
		System.out.println("bean = " + bean);

		DruidDataSource ds = ctx.getBean(DruidDataSource.class);
		System.out.println("ds = " + ds);
		System.out.println("ds.getDriverClassName() = " + ds.getDriverClassName());
	}

}
