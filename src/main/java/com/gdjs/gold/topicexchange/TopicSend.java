package com.gdjs.gold.topicexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "topic exchange test ";

//        amqpTemplate.convertAndSend("topicExchange","quick.orange.rabbit",message);
//        amqpTemplate.convertAndSend("topicExchange","lazy.orange.elephant",message);
//        amqpTemplate.convertAndSend("topicExchange","quick.orange.fox",message);
//        amqpTemplate.convertAndSend("topicExchange","lazy.brown.fox",message);
//        amqpTemplate.convertAndSend("topicExchange","lazy.pink.rabbit",message);
//        amqpTemplate.convertAndSend("topicExchange","quick.brown.fox",message);
//        amqpTemplate.convertAndSend("topicExchange","orange",message);
//        amqpTemplate.convertAndSend("topicExchange","quick.orange.male.rabbit",message);
        amqpTemplate.convertAndSend("topicExchange","lazy.orange.male.rabbit",message);

        System.out.println("send message done");
    }
}
