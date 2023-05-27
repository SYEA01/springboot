package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
}
