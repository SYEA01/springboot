package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//webEnvironment 默认是 SpringBootTest.WebEnvironment.NONE，意思是不带web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)  //随机端口
@AutoConfigureMockMvc  //开启虚拟MVC的调用
public class WebTest {

    // 方式1，注入MockMvc
//    @Autowired
//    private MockMvc mockMvc;

//    @Test
//    void testWeb(@Autowired MockMvc mockMvc) throws Exception {  //方式2，将MockMvc放到参数中
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");  //模拟虚拟的http请求
//        mockMvc.perform(builder);  //执行
//    }

    @Test
    void testStatus(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books1");
        ResultActions action = mockMvc.perform(builder);

        //设定预期值 与真实值进行比较
        StatusResultMatchers status = MockMvcResultMatchers.status();  //当前模拟运行的状态
        ResultMatcher ok = status.isOk();  // 预期值  200

        action.andExpect(ok);  //添加预期值到本次调用过程中进行匹配
    }

    @Test
    void testBody(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mockMvc.perform(builder);

        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.json("{\"id\":1,\"name\":\"spriangboot\",\"type\":\"springbo2ot\",\"description\":\"springboot\"}");

        action.andExpect(body);  // 匹配

    }

    @Test
    void testContentType(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mockMvc.perform(builder);

        //定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        action.andExpect(contentType);  // 匹配

    }

    @Test
    void testGetById(@Autowired MockMvc mockMvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mockMvc.perform(builder);

        //测试状态码
        StatusResultMatchers status = MockMvcResultMatchers.status();  //当前模拟运行的状态
        ResultMatcher ok = status.isOk();  // 预期值  200
        action.andExpect(ok);  //添加预期值到本次调用过程中进行匹配

        //测试响应体
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher body = content.json("{\"id\":1,\"name\":\"springboot\",\"type\":\"springboot\",\"description\":\"springboot\"}");
        action.andExpect(body);  // 匹配

        //测试响应头
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);  // 匹配
    }
}
