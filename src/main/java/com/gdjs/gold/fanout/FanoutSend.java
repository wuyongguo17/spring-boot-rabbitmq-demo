package com.gdjs.gold.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "fanout exchange test ";

        amqpTemplate.convertAndSend("fanoutExchange","",message);

        System.out.println("send message done");
    }
}
