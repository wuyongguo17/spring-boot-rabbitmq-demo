package com.gdjs.gold.headexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadersExchangeSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String msg = "headersExchange test";
        MessageProperties properties = new MessageProperties();
        properties.setHeader("header1", "value1");
        properties.setHeader("header2", "value2");
        Message obj = new Message(msg.getBytes(), properties);
        amqpTemplate.convertAndSend("HEADERS_EXCHANGE", "", obj);

        System.out.println("send message done");
    }
}
