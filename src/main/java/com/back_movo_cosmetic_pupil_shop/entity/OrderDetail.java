package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-04-19 10:46:50
 */
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -12083967626205956L;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 商品id
     */
    private Integer goodId;
    /**
     * 所选商品种类id
     */
    private Integer gTypeId;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品数量
     */
    private Integer num;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getGTypeId() {
        return gTypeId;
    }

    public void setGTypeId(Integer gTypeId) {
        this.gTypeId = gTypeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}

