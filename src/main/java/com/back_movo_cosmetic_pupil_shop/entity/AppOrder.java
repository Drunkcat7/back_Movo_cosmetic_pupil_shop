package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;

import java.util.List;

@Data
public class AppOrder {
    /**
     * 订单总价格
     */
    private Double priceSum;
    /**
     * 地址id
     */
    private Integer addressId;

    private List<OrderDetail> orderDetails;

}

