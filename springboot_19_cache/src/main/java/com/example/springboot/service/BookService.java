package com.example.springboot.service;

import com.example.springboot.domain.Book;

import java.util.List;

public interface BookService {

    boolean save(Book book);
    Book getById(Integer id);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
}
