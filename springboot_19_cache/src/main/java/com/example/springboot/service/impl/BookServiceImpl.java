package com.example.springboot.service.impl;

import com.example.springboot.dao.BookDao;
import com.example.springboot.domain.Book;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    //手动模拟缓存
    private HashMap<Integer,Book> cache = new HashMap();

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Book getById(Integer id) {
        //如果当前缓存中没有本次要查询的数据，就查询
        Book book = cache.get(id);
        if (book==null){
            Book queryBook = bookDao.selectById(id);
            cache.put(id,queryBook);
        }
        return cache.get(id);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
