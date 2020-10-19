package com.imooc.service.impl;

import com.imooc.constant.ResultEnum;
import com.imooc.dto.OrderDto;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-2020-19 13:03:25
 * @description :  买家服务接口实现
 * @since :  v1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDto cancel(String openid, String orderId) {
        OrderDto orderDto = checkOrderOwner(openid, orderId);
        if (orderDto == null) {
            log.error("[取消订单] 订单不存在, openid={}, orderId={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDto;
    }

    // 判断当前用户是否查询的是自己的订单
    private OrderDto checkOrderOwner(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null) {
            return null;
        }
        if (orderDto.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("[查询订单] 订单不属于当前用户, openid={}, orderId={}", openid, orderId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDto;
    }
}
