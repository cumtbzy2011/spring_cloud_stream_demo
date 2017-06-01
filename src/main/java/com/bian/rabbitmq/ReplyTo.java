package com.bian.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Mr.Bi on 2017/6/1.
 */
public interface ReplyTo {
    String INPUT = "reply-to";
    String OUTPUT = "reply-to";

    @Input(ReplyTo.INPUT)
    SubscribableChannel input();

    @Output(ReplyTo.OUTPUT)
    MessageChannel output();
}
