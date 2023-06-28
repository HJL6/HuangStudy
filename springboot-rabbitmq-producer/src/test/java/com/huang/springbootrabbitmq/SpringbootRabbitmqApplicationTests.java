package com.huang.springbootrabbitmq;

import com.huang.springbootrabbitmq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void test1() {
        orderService.makeOrderFanout("1","1",12);
    }

    @Test
    public void test2() {
        orderService.makeOrderDirect("2","2",12);
    }

    @Test
    public void test3() {
        orderService.makeOrderTopic("3","3",12);
    }

    @Test
    public void test4() {
        orderService.makeOrderTtl("4","4",12);
    }
}
