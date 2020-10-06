package com.imooc.service.impl;

import com.imooc.dto.OrderDto;
import com.imooc.po.OrderDetail;
import com.imooc.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:10 上午
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDto create(OrderDto OrderDto) {
        // TODO 完成创建订单的功能
        // 1. 查询商品
        // for(OrderDetail detail: OrderDto)

        // 2. 计算总价
        // 3. 写入数据库：order_master / order_detail
        // 4. 扣除库存

        return null;
    }

    @Override
    public OrderDto findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto pay(OrderDto orderDto) {
        return null;
    }
}
