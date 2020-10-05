package com.imooc.repository;

import com.imooc.po.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:11 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("https://xxx.jpg");
        productInfo.setCategoryType(3);
        productInfo.setProductStatus(0);

        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatusTest() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}