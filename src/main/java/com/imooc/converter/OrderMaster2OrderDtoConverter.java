package com.imooc.converter;

import com.imooc.dto.OrderDto;
import com.imooc.po.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/9 5:53 下午
 */
public class OrderMaster2OrderDtoConverter {
    public static OrderDto convert(OrderMaster orderMaster) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);
        return orderDto;
    }

    public static List<OrderDto> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(OrderMaster2OrderDtoConverter::convert).collect(Collectors.toList());
    }
}
