package com.imooc.service;

import com.imooc.dto.OrderDto;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-2020-19 12:58:36
 * @description :  买家服务接口
 * @since :  v1.0
 */
public interface BuyerService {

    OrderDto findOrderOne(String openid, String orderId);

    OrderDto cancel(String openid, String orderId);

}
