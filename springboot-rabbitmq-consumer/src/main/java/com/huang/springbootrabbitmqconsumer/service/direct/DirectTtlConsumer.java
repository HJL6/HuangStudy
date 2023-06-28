package com.huang.springbootrabbitmqconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"ttl.direct.queue"})
public class DirectTtlConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("ttl.direct.queue----接收到订单信息是:->"+message);
    }
}
