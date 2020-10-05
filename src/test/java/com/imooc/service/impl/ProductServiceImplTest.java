package com.imooc.service.impl;

import com.imooc.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:37 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOneTest() {
        ProductInfo productInfo = productService.findByProductId("123456");
        Assert.assertEquals("123456", productInfo.getProductId());

    }

    @Test
    public void findUpAllTest() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
    }

    @Test
    public void findAllTest() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> result = productService.findAll(request);
        logger.info("result is {}", result.getTotalElements());
    }

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("很好吃的皮皮虾");
        productInfo.setProductIcon("https://xxx.jpg");
        productInfo.setCategoryType(3);
        productInfo.setProductStatus(1);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);

    }
}
