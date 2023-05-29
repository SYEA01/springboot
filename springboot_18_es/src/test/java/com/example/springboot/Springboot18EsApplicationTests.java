package com.example.springboot;

import com.example.springboot.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        bookDao.selectById(1);
    }

}
