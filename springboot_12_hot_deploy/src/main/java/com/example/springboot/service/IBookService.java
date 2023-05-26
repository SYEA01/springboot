package com.example.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.domain.Book;

public interface IBookService extends IService<Book> {

    IPage getPage(int currentPage, int pageSize, Book book);
}
