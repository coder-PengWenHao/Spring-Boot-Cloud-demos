package com.coderpwh.rabbitmqdemo.producer;

import com.coderpwh.rabbitmqdemo.RabbitmqDemoApplication;
import com.coderpwh.rabbitmqdemo.message.Demo04Message;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoApplication.class)
public  class Demo04ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Demo04Producer producer;


    @Test
    public void testSyncSendSuccess() throws InterruptedException{
        int id =(int)(System.currentTimeMillis()/1000);
        producer.syncSend(id, Demo04Message.HEADER_VALUE);
        logger.info("[testSyncSend] [发送编号:[{}]发送成功]",id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }





}