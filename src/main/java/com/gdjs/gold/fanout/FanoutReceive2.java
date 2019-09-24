package com.gdjs.gold.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive2 {
    @RabbitListener(queues = "fanoutQueue2")
    public void receive(String message){
        System.out.println("FanoutReceive2 received message：" + message);
    }
}
