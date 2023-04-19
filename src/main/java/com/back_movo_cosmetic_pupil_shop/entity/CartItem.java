package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;

@Data
public class CartItem {
    /**
     * 购物车id
     */
    private Integer cartId;
    /**
     * 商品id
     */
    private Integer goodId;
    /**
     * 商品种类id
     */
    private Integer gTypeId;
    /**
     * 种类名称，比如：胶片棕
     */
    private String name;
    /**
     * 商品种类缩略图
     */
    private String img;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 商品名
     */
    private String gname;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品主图=>商品外部展示的缩略图
     */
    private String mainImg;
}
