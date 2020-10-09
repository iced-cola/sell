package com.imooc.service.impl;

import com.imooc.constant.OrderStatusEnum;
import com.imooc.constant.PayStatusEnum;
import com.imooc.constant.ResultEnum;
import com.imooc.converter.OrderMaster2OrderDtoConverter;
import com.imooc.dto.CartDto;
import com.imooc.dto.OrderDto;
import com.imooc.exception.SellException;
import com.imooc.po.OrderDetail;
import com.imooc.po.OrderMaster;
import com.imooc.po.ProductInfo;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.repository.OrderMasterRepository;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import com.imooc.util.KeyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:10 上午
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 参数：productId 和 productQuantity
     *
     * @param orderDto 商品id 和 商品数量
     * @return 商品入库
     */
    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal("0");
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productService.findByProductId(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 计算一件商品的总价总价
            orderAmount = orderAmount.add(productInfo.getProductPrice()
                    .multiply(BigDecimal.valueOf(orderDetail.getProductQuantity())));

            // 订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            String detailId = KeyUtils.genUniqueKey();
            orderDetail.setDetailId(detailId);
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);

            // 订单主表
            OrderMaster orderMaster = new OrderMaster();
            BeanUtils.copyProperties(orderDto, orderMaster);
            orderMaster.setOrderId(orderId);
            orderMaster.setOrderAmount(orderAmount);
            orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
            orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
            orderMasterRepository.save(orderMaster);

            // 扣除库存
            CartDto cartDto = new CartDto(orderDetail.getProductId(), orderDetail.getProductQuantity());
            productService.decreaseStock(Collections.singletonList(cartDto));
        }

        return null;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        // 不需要查订单详情
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDto> orderDtos = OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());
        return new PageImpl<>(orderDtos, pageable, orderMasterPage.getSize());
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        // 1. 判断订单状态
        Optional<OrderMaster> orderMaster = orderMasterRepository.findById(orderDto.getOrderId());
        if (!OrderStatusEnum.NEW.equals(orderMaster.get().getOrderStatus())) {
            log.error("[取消订单] 订单状态不正确，OrderId={}. orderStatus={}", orderDto.getOrderId(), orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        // 2. 修正订单状态
        orderDto.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        if (result == null) {
            log.error("[取消订单] 订单状态更新失败，orderId={}, orderStatus={}", orderDto.getOrderId(), orderDto.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        // 3. 返还库存


        // 4. 退款（如果已支付）

        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto pay(OrderDto orderDto) {
        return null;
    }
}
