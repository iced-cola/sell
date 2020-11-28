package com.imooc.service.impl;

import com.imooc.po.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/4 11:52 下午
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findByCategoryId(Integer categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public List<String> findAllCategoryName() {
        List<ProductCategory> allCategory = categoryRepository.findAll();
        if (!CollectionUtils.isEmpty(allCategory)) {
            return allCategory
                    .stream()
                    .map(ProductCategory::getCategoryName)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
