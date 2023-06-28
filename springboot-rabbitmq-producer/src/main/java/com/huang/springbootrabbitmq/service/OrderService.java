package com.huang.springbootrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrderFanout(String userId,String productId,Integer num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功:"+orderId);
        //3.通过mq来完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "direct-order-exchange";
        String routeKey = "";
        rabbitTemplate.convertAndSend(exchangeName,routeKey,orderId);
    }

    public void makeOrderDirect(String userId,String productId,Integer num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功:"+orderId);
        //3.通过mq来完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "direct-order-exchange";
        rabbitTemplate.convertAndSend(exchangeName,"sms",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"email",orderId);
    }

    public void makeOrderTopic(String userId,String productId,Integer num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功:"+orderId);
        //3.通过mq来完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "topic-order-exchange";
        rabbitTemplate.convertAndSend(exchangeName,"com",orderId);
    }

    public void makeOrderTtl(String userId,String productId,Integer num){
        //1.根据商品id查询库存是否充足
        //2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功:"+orderId);
        //3.通过mq来完成消息的分发
        //参数1:交换机  参数2:路由key/queue队列名称  参数3:消息内容
        String exchangeName = "direct-ttl-exchange";
        rabbitTemplate.convertAndSend(exchangeName,"ttl",orderId);
    }
}
