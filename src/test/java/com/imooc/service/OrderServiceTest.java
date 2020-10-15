package com.imooc.service;

import com.imooc.constant.OrderStatusEnum;
import com.imooc.constant.PayStatusEnum;
import com.imooc.dto.OrderDto;
import com.imooc.po.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

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
    void findOneTest() {
        String orderId = "1602064689031682534";
        OrderDto orderDto = orderService.findOne(orderId);
        logger.info("find result: {}", orderDto);
    }

    @Test
    void findListTest() {
        Page<OrderDto> list = orderService.findList("110110", PageRequest.of(0, 2));
        Assert.assertNotNull(list);
    }

    @Test
    void cancelTest() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("1602064689031682534");
        orderDto.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDto.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1602064689223113312");
        orderDetail.setProductId("100002");
        orderDetail.setProductQuantity(1);
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setDetailId("1602064689324975606");
        orderDetail1.setProductId("100003");
        orderDetail1.setProductQuantity(3);
        orderDto.setOrderDetailList(new ArrayList<>() {{
            add(orderDetail);
            add(orderDetail1);
        }});
        OrderDto result = orderService.cancel(orderDto);
        Assert.assertNotNull(result);
    }

    @Test
    void finishTest() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("100100");
        orderService.finish(orderDto);
    }

    @Test
    void payTest() {
    }
}