package com.coderpwh.consumer.producer;


import com.coderpwh.consumer.RabbitmqDemoBatchConsumerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqDemoBatchConsumerApplication.class)
@Slf4j
public class Demo06ProducerTest {


    @Autowired
    private Demo06Producer producer;

    @Test
    public void testSyncSend() throws InterruptedException {

        for(int i=0;i<3;i++){
            // 同步发送消息
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);

            // 故意每条消息之间，隔离 10 秒
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
            Thread.sleep(10 * 1000L);
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }



}