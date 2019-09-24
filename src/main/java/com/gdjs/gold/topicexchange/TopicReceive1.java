package com.gdjs.gold.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive1 {

    @RabbitListener(queues = "topicQueue1")
    public void receiveTopic1(String message){
        System.out.println("topic queue1 received message："+message);
    }
}
