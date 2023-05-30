package com.example.springboot.controller;

import com.example.springboot.domain.Book;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Boolean Save(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.update(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping
    public List<Book> getAll(){
        return  bookService.getAll();
    }
}
