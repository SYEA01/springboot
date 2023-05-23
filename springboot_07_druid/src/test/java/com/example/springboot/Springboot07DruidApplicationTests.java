package com.example.springboot;

import com.example.springboot.dao.UserDao;
import com.example.springboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07DruidApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		User user = userDao.getById(10);
		System.out.println("user = " + user);
	}

}
