package com.imooc.dto;

import lombok.Data;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 5:08 下午
 */
@Data
public class CartDto {

    private String productId;

    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
