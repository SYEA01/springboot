package com.example.springboot.controller.config;

import com.example.springboot.domain.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        e.printStackTrace();
        return new R("服务器故障，请稍后再试");
    }
}
