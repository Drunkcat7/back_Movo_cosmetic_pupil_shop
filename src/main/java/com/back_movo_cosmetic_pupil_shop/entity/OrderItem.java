package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;

@Data
public class OrderItem {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 商品种类缩略图
     */
    private String img;
    /**
     * 种类名称，比如：胶片棕
     */
    private String name;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 联系人
     */
    private String consignee;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 是否为默认联系人，1是，0或者null代表不是
     */
    private Integer defaultContact;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 商品名
     */
    private String gname;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 订单状态{0=待付款，1=待发货，2=待收货，3=待评价}
     */
    private Integer productStatus;
    /**
     * 订单总价格
     */
    private Double priceSum;
}
