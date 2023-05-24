package com.example.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        Book book = bookService.getById(1);
        System.out.println("book = " + book);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        Boolean bl = bookService.save(book);
        System.out.println("bl = " + bl);

    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(55);
        book.setType("测试数据324234");
        book.setName("测试数据43423423");
        book.setDescription("测试数据123");
        Boolean bl = bookService.updateById(book);//根据id修改
        System.out.println("bl = " + bl);
    }

    @Test
    void testDelete() {
        Boolean bl = bookService.removeById(54);// 根据id删除
        System.out.println("bl = " + bl);
    }

    @Test
    void testGetAll() {
        List<Book> books = bookService.list();  // 查询所有
        books.forEach(System.out::println);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2,4);
        bookService.page(page);
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getRecords() = " + page.getRecords());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
    }
}
