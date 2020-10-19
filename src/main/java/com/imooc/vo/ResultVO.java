package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 3:44 下午
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    private Integer code;

    private String msg = "";

    private T data;

}
