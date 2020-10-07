package com.imooc.dto;

import com.imooc.po.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:06 上午
 */
@Data
public class OrderDto {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    // 订单总价
    private BigDecimal orderAmount;

    // 订单状态默认为"新建订单"
    private Integer orderStatus;

    // 支付状态默认为"等待支付"
    private Integer payStatus;

    private String detailId;

    private String productId;

    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    private String productIcon;

    List<OrderDetail> orderDetailList;
}
