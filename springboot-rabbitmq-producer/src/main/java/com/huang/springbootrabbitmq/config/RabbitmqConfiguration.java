package com.huang.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {
    //1:声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout-order-exchange",true,false);
    }
    //2:声明队列
    @Bean
    public Queue smsQueue(){
        return  new Queue("sms.fanout.queue",true);
    }
    @Bean
    public Queue shortMessageQueue(){
        return  new Queue("shortMessage.fanout.queue",true);
    }
    @Bean
    public Queue emailQueue(){
        return  new Queue("email.fanout.queue",true);
    }
    //3:完成绑定关系:声明注册fanout模式的交换机
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding shortMessageBinding(){
        return BindingBuilder.bind(shortMessageQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    //1:声明注册fanout模式的交换机
}
