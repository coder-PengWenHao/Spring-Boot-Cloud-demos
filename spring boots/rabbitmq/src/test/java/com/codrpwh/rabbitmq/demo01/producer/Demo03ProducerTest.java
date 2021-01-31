package com.codrpwh.rabbitmq.demo01.producer;


import com.codrpwh.rabbitmq.RabbitmqApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
@Slf4j
public class Demo03ProducerTest {


    @Resource
    private Demo03Producer producer;


    @Test
    public void testSyncSend() throws InterruptedException {

        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


}
