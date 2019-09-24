package com.gdjs.gold.demo1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wyg
 * @Date 2019/9/23 12:18
 */
@Component
public class Send {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "hello world";
        amqpTemplate.convertAndSend("hello",message);
        System.out.println("send message done");
    }

}
