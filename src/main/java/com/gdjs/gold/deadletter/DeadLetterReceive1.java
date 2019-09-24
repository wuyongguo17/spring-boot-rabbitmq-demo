package com.gdjs.gold.deadletter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterReceive1 {
    @RabbitListener(queues = "REDIRECT_QUEUE")
    public void receive(String message){
        System.out.println("deadLetterReceive1 received message：" + message);
    }
}
