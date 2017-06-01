package com.bian.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by Mr.Bi on 2017/6/1.
 */
@EnableBinding(value = Source.class)
public class Producer {

    //这里定义的是一个内置的生产者，会被轮询调用
    //该方法如果有参数将由Spring 注入，不能手动调用来发送自定义信息
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
    public MessageSource<String> produce() {
        return () -> new GenericMessage<>("{\"id\":\"1\", \"body\":\"hello\"}");
    }
}
