package com.gdjs.gold.demo1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author wyg
 * @Date 2019/9/23 12:18
 */
@Component
public class Receive {

    @RabbitListener(queues = "hello")
    public void receive(String message){
        System.out.println("receive message：" + message);
    }

}
