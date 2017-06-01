package com.bian.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Mr.Bi on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MQTest {

    @Autowired
    ManualProducer producer;

    @Test
    public void test() throws InterruptedException {
//        producer.produce();xxxx
//        不用调用，是框架自动轮询的
        new ArrayBlockingQueue(1).take();
    }

    @Test
    public void testSend() throws InterruptedException {
        producer.send("exahello!");
        new ArrayBlockingQueue(1).take();
    }
}
