package com.imooc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.constant.ResultEnum;
import com.imooc.dto.OrderDto;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.po.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/17 11:45 上午
 */
@Slf4j
public class OrderForm2OrderDto {
    public static OrderDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("[对象转换] 参数不正确, String={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
