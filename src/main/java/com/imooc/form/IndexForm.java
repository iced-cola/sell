package com.imooc.form;

import com.imooc.po.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  11-28-2020 12:07:27
 * @description :  小程序首页form
 * @since :  v1.0
 */
@Data
public class IndexForm {

    // 所有商品分类
    private List<String> categoryList;

    // 所有商品
    private List<ProductInfo> productInfoList;

}
