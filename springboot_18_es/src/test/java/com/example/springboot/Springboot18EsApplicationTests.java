package com.example.springboot;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Springboot18EsApplicationTests {
    //    @Autowired
//    private ElasticsearchRestTemplate template;   // 不推荐使用，老版本


    private RestHighLevelClient client;

    @BeforeEach
    void setUp() {
        //连接
        HttpHost host = HttpHost.create("http://192.168.0.111:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    void tearDown() throws IOException {
        //关闭
        client.close();
    }

    /**
     * 创建索引
     */
    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }
}