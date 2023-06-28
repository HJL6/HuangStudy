package com.huang.springbootrabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TtlRabbitmqConfiguration {
    //1:声明注册direct模式的交换机
    @Bean
    public DirectExchange directExchangeTtl(){
        return new DirectExchange("direct-ttl-exchange",true,false);
    }
    //2:队列的过期时间
    @Bean
    public Queue ttlDirectQueue(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",5000);
        return  new Queue("ttl.direct.queue",true,false,false,args);
    }
    @Bean
    public Binding directTtlBinding(){
        return BindingBuilder.bind(ttlDirectQueue()).to(directExchangeTtl()).with("ttl");
    }

}
