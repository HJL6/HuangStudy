package com.huang.springbootrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"shortMessage.fanout.queue"})
public class ShortMessageConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("shortMessage.fanout.queue----接收到订单信息是:->"+message);
    }
}
