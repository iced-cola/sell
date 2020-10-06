package com.imooc.constant;

import lombok.Getter;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:17 上午
 */
@Getter
public enum ResultEnum {

    // command + shift + u 大写快捷键
    PRODUCT_NOT_EXIST(10, "商品不存在");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
