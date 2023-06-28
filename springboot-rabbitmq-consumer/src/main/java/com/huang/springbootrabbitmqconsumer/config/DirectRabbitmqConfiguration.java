package com.huang.springbootrabbitmqconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitmqConfiguration {
    //1:声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct-order-exchange",true,false);
    }
    //2:声明队列
    @Bean
    public Queue smsDirectQueue(){
        return  new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue shortMessageDirectQueue(){
        return  new Queue("shortMessage.direct.queue",true);
    }
    @Bean
    public Queue emailDirectQueue(){
        return  new Queue("email.direct.queue",true);
    }
    //3:完成绑定关系:声明注册direct模式的交换机
    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding shortMessageBinding(){
        return BindingBuilder.bind(shortMessageDirectQueue()).to(directExchange()).with("shortMessage");
    }
    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("email");
    }
    //1:声明注册direct模式的交换机
}
