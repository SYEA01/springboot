package com.example.springboot.domain;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private String type;
    private String description;
}
