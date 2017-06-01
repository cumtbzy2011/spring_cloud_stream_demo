package com.bian.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * Created by Mr.Bi on 2017/6/1.
 */
@EnableBinding(value = {Sink.class, ReplyTo.class})
public class Consumer {

    @StreamListener(Sink.INPUT)
    @SendTo(ReplyTo.OUTPUT)
    public String receive(Object payLoad) {
        //payLoad就是message的body
        System.out.println("Receive: " + payLoad);
        return "Receive: " + payLoad;
    }

    @StreamListener(ReplyTo.INPUT)
    public void receiveReply(Object payLoad) {
        System.out.println("receive Reply: " + payLoad);
    }
}
