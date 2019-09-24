package com.gdjs.gold.workqueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wyg
 * @Date 2019/9/23 14:48
 */
@Component
public class WorkQueueSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "work queue ";
        for (int i = 0;i < 10;i++){
            amqpTemplate.convertAndSend("workQueue",message + i);
        }
        System.out.println("send message done");
    }
}
