package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2023-04-19 10:40:05
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 172090877022173185L;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 订单状态{0=待付款，1=待发货，2=待收货，3=待评价}
     */
    private Integer productStatus;
    /**
     * 订单总价格
     */
    private Double priceSum;
    /**
     * 地址id
     */
    private Integer addressId;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

}

