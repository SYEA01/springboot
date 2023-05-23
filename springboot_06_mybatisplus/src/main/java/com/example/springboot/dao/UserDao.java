package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 使用mybatis-plus 很多基础的方法都在BaseMapper<T>接口中定义好了，使用的时候直接继承BaseMapper就行
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
