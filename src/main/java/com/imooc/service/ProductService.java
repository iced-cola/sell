package com.imooc.service;

import com.imooc.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:24 上午
 */
public interface ProductService {

    ProductInfo findByProductId(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存

    //减库存

}
