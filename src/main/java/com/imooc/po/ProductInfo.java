package com.imooc.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品信息
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:06 上午
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    // 单价
    private BigDecimal productPrice;

    // 库存
    private Integer productStock;

    private String productDescription;

    private String productIcon;

    // 状态 0:正常 1:下架
    private Integer productStatus;

    // 类别编号
    private Integer categoryType;

}
