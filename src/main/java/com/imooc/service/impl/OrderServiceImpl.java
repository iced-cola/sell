package com.imooc.service.impl;

import com.imooc.constant.OrderStatusEnum;
import com.imooc.constant.PayStatusEnum;
import com.imooc.constant.ResultEnum;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhulongkun20@163.com
 * @since 2020/10/7 12:10 上午
 */
@Service
public class OrderServiceImpl implements OrderService {

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
        return null;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
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
