package com.example.springboot;

import com.example.springboot.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCase {

    @Autowired
    private BookCase bookCase;

    @Test
    void test(){
        System.out.println("bookCase = " + bookCase);
    }

}
