package com.example.springboot;

import com.example.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setName("taoao");
        book.setType("student");
        book.setDescription("学生");
        mongoTemplate.save(book);
    }

    @Test
    void find() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println("all = " + all);
    }

}
