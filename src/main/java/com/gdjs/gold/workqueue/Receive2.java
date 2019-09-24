package com.gdjs.gold.workqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author wyg
 * @Date 2019/9/23 14:56
 */
//不要忘记添加@Component注解
@Component
public class Receive2 {
    @RabbitListener(queues = "workQueue")
    public void receive(String message){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("receive2 message：" + message);
    }
}
