package com.imooc.constant;

import lombok.Getter;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:28 上午
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
