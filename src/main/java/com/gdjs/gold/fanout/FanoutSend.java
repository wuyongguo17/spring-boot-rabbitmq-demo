package com.gdjs.gold.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    @Qualifier(value = "fanoutExchange")
    private FanoutExchange fanoutExchange;

    public void send(){
        String message = "fanout exchange test ";

//        amqpTemplate.convertAndSend("fanoutExchange","",message);
        //通过注入方式获取
        amqpTemplate.convertAndSend(fanoutExchange.getName(),"",message);

        System.out.println("send message done");
    }
}
