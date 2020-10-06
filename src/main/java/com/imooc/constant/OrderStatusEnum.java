package com.imooc.constant;

import lombok.Getter;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/6 11:21 下午
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "完结"),
    CANCEL(2, "取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
