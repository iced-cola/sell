package com.imooc.service;

import com.imooc.dto.OrderDto;
import com.imooc.po.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:02 上午
 */
public interface OrderService {

    /**
     * 创建订单
     */
    OrderDto create(OrderDto OrderDto);

    /**
     * 查询单个订单
     */
    OrderDto findOne(String orderId);

    /**
     * 查询订单列表
     */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDto cancel(OrderDto orderDto);

    /**
     * 完结订单
     */
    OrderDto finish(OrderDto orderDto);

    /**
     * 支付订单
     */
    OrderDto pay(OrderDto orderDto);
}
