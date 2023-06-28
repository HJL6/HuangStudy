package com.huang.springbootrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"sms.fanout.queue"})
public class SmsConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("sms.fanout.queue----接收到订单信息是:->"+message);
    }
}
