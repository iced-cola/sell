package com.imooc.vo;

import lombok.Data;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 3:44 下午
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
