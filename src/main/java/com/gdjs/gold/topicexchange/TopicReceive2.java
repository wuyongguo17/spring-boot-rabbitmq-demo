package com.gdjs.gold.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive2 {

    @RabbitListener(queues = "topicQueue2")
    public void receiveTopic1(String message){
        System.out.println("topic queue2 received message："+message);
    }
}
