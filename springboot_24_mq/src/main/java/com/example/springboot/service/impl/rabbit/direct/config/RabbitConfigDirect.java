//package com.example.springboot.service.impl.rabbit.direct.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class RabbitConfigDirect {
//
//    //定义存储消息的消息队列对象
//
//    /**
//     * 可以定义多个Queue类型的Bean，就是定义多个队列
//     * @return
//     */
//    @Bean
//    public Queue directQueue(){
//        //name:队列名称
//        //druable:是否持久化，默认false
//        //exclusive:是否当前连接专用，默认false。连接关闭之后队列就被删除
//        //autoDelete:是否自动删除，当生产者或消费者不再使用此队列，自动删除
//        return new Queue("direct_queue");  // 队列名字
//    }
//
//    //定义交换机，用于绑定上面的消息队列
//    /**
//     * 一个交换机可以绑定多个队列
//     * @return
//     */
//    @Bean
//    public DirectExchange directExchange(){
//        return new DirectExchange("directExchange");
//    }
//
//    //把上面的交换机和消息队列绑定起来
//
//    /**
//     * 可以定义多个Binding类型的Bean
//     * @return
//     */
//    @Bean
//    public Binding bindingDirect(){
//        return BindingBuilder.bind(directQueue()).to(directExchange())  //绑定
//                .with("direct");  //起个名称，也就是 routingKey
//    }
//
//}
