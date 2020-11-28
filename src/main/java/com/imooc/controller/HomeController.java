package com.imooc.controller;

import com.imooc.form.IndexForm;
import com.imooc.po.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.util.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  11-28-2020 12:04:40
 * @description :  初始化页面接口
 * @since :  v1.0
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductService productService;

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/init")
    public ResultVO<Object> init() {

        // 获取所有商品分类
        List<String> allCategoryName = categoryService.findAllCategoryName();

        // 获取所有的商品信息
        List<ProductInfo> productInfoList = productService.findUpAll();

        IndexForm indexForm = new IndexForm();
        indexForm.setCategoryList(allCategoryName);
        indexForm.setProductInfoList(productInfoList);
        return ResultVOUtil.success(indexForm);
    }

}
