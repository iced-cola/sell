package com.imooc.repository;

import com.imooc.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/5 12:09 上午
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    ProductInfo findByProductId(String productId);

    List<ProductInfo> findAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
