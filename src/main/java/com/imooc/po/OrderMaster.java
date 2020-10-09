package com.imooc.po;

import com.imooc.constant.OrderStatusEnum;
import com.imooc.constant.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 *
 * @author zhulongkun20@163.com
 * @since 2020/10/6 11:18 下午
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    // 订单状态默认为"新建订单"
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态默认为"等待支付"
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

}
