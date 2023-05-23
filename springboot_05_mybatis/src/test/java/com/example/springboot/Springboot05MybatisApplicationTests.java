package com.example.springboot;

import com.example.springboot.dao.BookDao;
import com.example.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = bookDao.getById(10);
        System.out.println("book = " + book);
    }
}
