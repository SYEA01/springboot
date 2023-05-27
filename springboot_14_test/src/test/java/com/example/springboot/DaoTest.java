package com.example.springboot;

import com.example.springboot.domain.Book;
import com.example.springboot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(true)   // 如果不设置@Rollback注解，或者是true，事务会自动回滚 ； 反之不会
public class DaoTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("springboot22222");
        book.setType("springboot");
        book.setDescription("springboot");
        bookService.save(book);
    }
}
