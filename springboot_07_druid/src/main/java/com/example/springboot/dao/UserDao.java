package com.example.springboot.dao;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from t_user where id = #{id};")
    User getById(@Param("id")Integer id);
}
