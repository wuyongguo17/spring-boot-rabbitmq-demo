package com.gdjs.gold.workqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author wyg
 * @Date 2019/9/23 14:49
 */
@Component
public class Receive1 {
    @RabbitListener(queues = "workQueue")
    public void receive(String message){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("receive1 message：" + message);
    }
}
