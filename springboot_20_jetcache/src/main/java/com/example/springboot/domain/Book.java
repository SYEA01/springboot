package com.example.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
