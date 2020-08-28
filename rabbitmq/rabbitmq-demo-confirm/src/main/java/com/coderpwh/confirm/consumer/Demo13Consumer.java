package com.coderpwh.confirm.consumer;

import com.coderpwh.confirm.message.Demo13Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Demo13Message.QUEUE)
@Slf4j
public class Demo13Consumer {


    @RabbitHandler
    public void onMessage(Demo13Message message) {
        log.info("[消费方]---[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }


}
