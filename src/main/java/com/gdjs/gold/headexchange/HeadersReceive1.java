package com.gdjs.gold.headexchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeadersReceive1 {
    @RabbitListener(queues = "HEADER_QUEUE")
    public void receiveHeaderQueue(byte[] message) {
        System.out.println("header queue received message:" + new String(message));
    }
}
