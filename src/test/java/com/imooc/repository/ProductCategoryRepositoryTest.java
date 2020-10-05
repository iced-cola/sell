package com.imooc.repository;

import com.imooc.po.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 12:46 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = {"com.imooc.repository"})
@EntityScan("com.imooc.po")
public class ProductCategoryRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(ProductCategoryRepositoryTest.class);

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
        logger.info("test result: {}", productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("本月热销");
        productCategory.setCategoryType(1);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void updateTest() {

    }
}