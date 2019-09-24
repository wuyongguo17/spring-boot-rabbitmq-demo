package com.gdjs.gold.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wyg
 * @Date 2019/9/23 12:09
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    @Bean
    public Queue workQueue(){
        return new Queue("workQueue");
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding topicBinding3(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("lazy.#");
    }

    //创建directExchange
    @Bean("deadLetterExchange")
    public Exchange deadLetterExchange() {
        return ExchangeBuilder.directExchange("DL_EXCHANGE").durable(true).build();
    }

    //死信队列：生产者 --> 消息 --> 交换机 --> 队列 --> 变成死信 --> DLX交换机 -->队列 --> 消费者
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue() {
        Map<String, Object> args = new HashMap<>(2);
//       x-dead-letter-exchange    声明  死信交换机
        args.put("x-dead-letter-exchange", "DL_EXCHANGE");
//       x-dead-letter-routing-key    声明 死信路由键
        args.put("x-dead-letter-routing-key", "KEY_R");
        return QueueBuilder.durable("DL_QUEUE").withArguments(args).build();
    }

    @Bean("redirectQueue")
    public Queue redirectQueue() {
        //默认持久化
        return QueueBuilder.durable("REDIRECT_QUEUE").build();
    }

    /**
     * 死信路由通过 DL_KEY 绑定键绑定到死信队列上.
     *
     * @return the binding
     */
    @Bean
    public Binding deadLetterBinding() {
        //两种方式都可以
//        return new Binding("DL_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "DL_KEY", null);
        return BindingBuilder.bind(deadLetterQueue()).to((DirectExchange)deadLetterExchange()).with("DL_KEY");
    }

    /**
     * 死信路由通过 KEY_R 绑定键绑定到死信队列上.
     *
     * @return the binding
     */

    @Bean
    public Binding redirectBinding() {
        return new Binding("REDIRECT_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "KEY_R", null);
    }
}
