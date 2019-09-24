package com.gdjs.gold.deadletter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 死信队列
 */
@Component
public class DeadLetterSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content = "dead letter queue test ";

        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
//            设置编码
            messageProperties.setContentEncoding("utf-8");
//            设置过期时间毫秒
            messageProperties.setExpiration(String.valueOf(5 * 1000));
            return message;
        };
        amqpTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", content, messagePostProcessor);
        System.out.println("send message done");
    }
}
