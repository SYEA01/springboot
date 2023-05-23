package com.example.springboot.dao;

import com.example.springboot.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from t_user where id = #{id}")
    Book getById(Integer id);
}
