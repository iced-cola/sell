package com.imooc.util;

import com.imooc.constant.CodeEnum;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-2020-19 14:04:07
 * @description :  枚举类取值工具
 * @since :  v1.0
 */
public class CodeEnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClazz) {
        for (T each : enumClazz.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
