package com.gdjs.gold.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive1 {
    @RabbitListener(queues = "fanoutQueue1")
    public void receive(String message){
        System.out.println("FanoutReceive1 received message：" + message);
    }
}
