package com.imooc.controller;

import com.imooc.service.CategoryService;
import com.imooc.util.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  11-28-2020 12:00:11
 * @description :  分类管理接口api
 * @since :  v1.0
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/all")
    public ResultVO<String> all() {
        List<String> allCategoryName = categoryService.findAllCategoryName();
        return ResultVOUtil.success(allCategoryName);
    }
}
