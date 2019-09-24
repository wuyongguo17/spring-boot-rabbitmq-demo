package com.gdjs.gold.controller;

import com.gdjs.gold.deadletter.DeadLetterSend;
import com.gdjs.gold.demo1.Send;
import com.gdjs.gold.fanout.FanoutSend;
import com.gdjs.gold.response.ResponseBean;
import com.gdjs.gold.topicexchange.TopicSend;
import com.gdjs.gold.workqueue.WorkQueueSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wyg
 * @Date 2019/9/23 13:29
 */
@RestController
public class RabbitMqController {
    @Autowired
    private Send send;

    @Autowired
    private WorkQueueSend workQueueSend;

    @Autowired
    private TopicSend topicSend;

    @Autowired
    private DeadLetterSend deadLetterSend;

    @Autowired
    private FanoutSend fanoutSend;

    @RequestMapping("/hello")
    public ResponseBean hello(){
        send.send();
        return ResponseBean.success("send message done");
    }


    @RequestMapping("/work")
    public ResponseBean workQueue(){
        workQueueSend.send();
        return ResponseBean.success("send message done");
    }

    @RequestMapping("/topic")
    public ResponseBean topicExchange(){
        topicSend.send();
        return ResponseBean.success("send message done");
    }

    @RequestMapping("/deadLetter")
    public ResponseBean deadLetter(){
        deadLetterSend.send();
        return ResponseBean.success("send message done");
    }

    @RequestMapping("/fanout")
    public ResponseBean fanoutExchange(){
        fanoutSend.send();
        return ResponseBean.success("send message done");
    }
}
