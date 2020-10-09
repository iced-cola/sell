package com.imooc.repository;

import com.imooc.po.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/6 11:35 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    private final String OPENID = "110110";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findByBuyerOpenid() {
    }

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("0002");
        orderMaster.setBuyerName("未知用户");
        orderMaster.setBuyerPhone("1234568");
        orderMaster.setBuyerAddress("未知地点");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal("45"));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
//        PageRequest pageRequest = new PageRequest(0, 5);
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(result);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}