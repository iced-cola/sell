package com.imooc.repository;

import com.imooc.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 12:45 下午
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory findByCategoryId(Integer categoryId);

}
