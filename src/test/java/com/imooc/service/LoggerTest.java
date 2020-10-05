package com.imooc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 12:06 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    // 必须写当前类
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        String username = "test";
        String password = "pass";
        logger.info("用户名：{}，密码：{}", username, password);
    }
}
