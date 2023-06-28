package com.huang.springbootrabbitmqconsumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "shortMessage.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic-order-exchange",type = ExchangeTypes.TOPIC),
        key = "#.com.#"
))
public class TopicShortMessageConsumer {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("shortMessage.topic.queue----接收到订单信息是:->"+message);
    }
}
