package com.example.springboot;

import com.alibaba.fastjson.JSON;
import com.example.springboot.dao.BookDao;
import com.example.springboot.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot18EsApplicationTests {
    //    @Autowired
//    private ElasticsearchRestTemplate template;   // 不推荐使用，老版本

    @Autowired
    private BookDao bookDao;

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

    /**
     * 创建索引 使用ik分词器
     */
    @Test
    void testCreateIndexByIk() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");

        //设置请求中的参数
        String json="{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    //添加文档
    @Test
    void testCreateDoc() throws IOException {
        Book book = bookDao.selectById(1);
        IndexRequest request = new IndexRequest("books").id(String.valueOf(book.getId()));
        String json= JSON.toJSONString(book);
        request.source(json,XContentType.JSON);
        client.index(request,RequestOptions.DEFAULT);
    }

    @Test
    void testCreateDocAll() throws IOException {
        List<Book> books = bookDao.selectList(null);
        BulkRequest bulk=new BulkRequest();

        for (Book book : books) {
            IndexRequest request = new IndexRequest("books").id(String.valueOf(book.getId()));
            String json= JSON.toJSONString(book);
            request.source(json,XContentType.JSON);
            bulk.add(request);
        }

        client.bulk(bulk,RequestOptions.DEFAULT);

    }
}