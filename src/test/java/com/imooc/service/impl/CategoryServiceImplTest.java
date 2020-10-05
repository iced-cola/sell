package com.imooc.service.impl;

import com.imooc.po.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 11:53 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = categoryService.findByCategoryId(1);
        logger.info("test result: {}", productCategory);
        Assert.assertNotNull(productCategory);
    }

}