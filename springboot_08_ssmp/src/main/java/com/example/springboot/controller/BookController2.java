package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot.domain.Book;
import com.example.springboot.domain.R;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books2")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if ("123".equals(book.getName())) {
            throw new IOException();
        }
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    //    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage page = bookService.getPage(currentPage, pageSize);
//        if (currentPage>page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }
    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage page = bookService.getPage(currentPage, pageSize,book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }

}
