package com.example.springboot;

import com.example.springboot.dao.BookDao;
import com.example.springboot.domain.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot15SqlApplicationTests {

//    @Autowired
//    private BookDao bookDao;

    @Test
    void contextLoads() {
//        bookDao.selectById(1);
    }


    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.forEach(System.out::println);
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book temp = new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setDescription(rs.getString("description"));

                return temp;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        list.forEach(System.out::println);
    }
    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tbl_book values(null,'springboot1','springboot2','springboot2')";
        jdbcTemplate.update(sql);
    }
}
