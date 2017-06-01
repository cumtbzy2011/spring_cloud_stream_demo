package com.bian.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.Bi on 2017/6/1.
 */
@Component
public class ManualProducer {

    @Autowired
    Source source;

    //手动调用，发送自定义信息的方法
    public void send(String messtr) {
        Message<String> message = MessageBuilder.withPayload("{\"id\":\"1\", \"body\":\"hello\"}").build();
        source.output().send(message);
    }
}
