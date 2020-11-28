package com.imooc.service;

import com.imooc.po.ProductCategory;

import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 11:50 下午
 */
public interface CategoryService {

    ProductCategory findByCategoryId(Integer categoryId);

    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    List<String> findAllCategoryName();

}

