package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testgetById() {
        Book book = bookDao.selectById(1);  // 根据id查询单个
        System.out.println("book = " + book);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);  //新增。需要配置id的策略
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(51);
        book.setType("测试数据324234");
        book.setName("测试数据43423423");
        book.setDescription("测试数据123");
        bookDao.updateById(book);  //根据id修改
    }

    @Test
    void testDelete() {
        bookDao.deleteById(51);  // 根据id删除
    }

    @Test
    void testGetAll() {
        List<Book> books = bookDao.selectList(null);  // 查询所有
        books.forEach(System.out::println);
    }

    @Test
    void testGetPage() {  // 分页
        IPage page = new Page(1, 5); // 第一页，每页显示5条
        bookDao.selectPage(page, null);
    }

    @Test
    void testGetByCondition() {  // 按条件查询
        //QueryWrapper就是查询条件
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");  //查询name中包含Spring的数据
        List<Book> books = bookDao.selectList(qw);
        books.forEach(System.out::println);
    }

    @Test
    void testGetByCondition2() {  // 按条件查询
        String name = "Spring";
        //LambdaQueryWrapper就是查询条件
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);  //查询name中包含Spring的数据, 第一个参数是布尔值，true就拼接like，false不拼接。可不写。
        List<Book> books = bookDao.selectList(lqw);
        books.forEach(System.out::println);
    }
}
















