package com.example.springboot;

import com.example.springboot.dao.UserDao;
import com.example.springboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot06MybatisplusApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		User user = userDao.selectById(10);
		System.out.println("user = " + user);
	}

	@Test
	void testGetAll(){
		List<User> users = userDao.selectList(null);
		users.forEach(System.out::println);
	}

}
