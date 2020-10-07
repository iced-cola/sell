package com.imooc.service;

import com.imooc.dto.OrderDto;
import com.imooc.po.OrderDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 5:23 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("测试用户名");
        orderDto.setBuyerAddress("测试收获地址");
        orderDto.setBuyerPhone("110110");
        orderDto.setBuyerOpenid("110110");

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("100002");
        orderDetail.setProductQuantity(1);
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("100003");
        orderDetail1.setProductQuantity(3);
        orderDto.setOrderDetailList(new ArrayList<>() {{
            add(orderDetail);
            add(orderDetail1);
        }});

        OrderDto dto = orderService.create(orderDto);
        logger.info("测试结果： {}", dto);
    }

    @Test
    void findOne() {
    }

    @Test
    void findList() {
    }

    @Test
    void cancel() {
    }

    @Test
    void finish() {
    }

    @Test
    void pay() {
    }
}