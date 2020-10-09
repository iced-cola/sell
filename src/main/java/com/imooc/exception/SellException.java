package com.imooc.exception;

import com.imooc.constant.ResultEnum;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:16 上午
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
