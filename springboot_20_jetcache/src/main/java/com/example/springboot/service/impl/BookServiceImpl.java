package com.example.springboot.service.impl;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.example.springboot.dao.BookDao;
import com.example.springboot.domain.Book;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @Cached(name = "book", key = "#id", expire = 3600)  // 保存到缓存，如果缓存中存在数据查询缓存
    @CacheRefresh(refresh = 10)  // 缓存多久查询一次数据库
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    @CacheUpdate(name = "book", key = "#book.id", value = "#book")  // 更新缓存
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book", key = "#id")  // 删除缓存
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
