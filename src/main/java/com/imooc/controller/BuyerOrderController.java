package com.imooc.controller;

import com.imooc.constant.ResultEnum;
import com.imooc.converter.OrderForm2OrderDto;
import com.imooc.dto.OrderDto;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import com.imooc.util.ResultVOUtil;
import com.imooc.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/17 11:29 上午
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        OrderDto orderDto = OrderForm2OrderDto.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("[创建订单] 购物车为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDto createResult = orderService.create(orderDto);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    // 订单列表
    public ResultVO<List<OrderDto>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "0") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单列表] openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);
        Page<OrderDto> orderDtoPage = orderService.findList(openid, request);
        return ResultVOUtil.success(orderDtoPage.getContent());
    }

    // 订单详情

    // 取消订单
}
