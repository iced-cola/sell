package com.imooc.util;

import java.util.Random;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:29 上午
 */
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     *
     * @return 唯一主键
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
