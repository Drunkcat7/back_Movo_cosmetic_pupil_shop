package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (ShoppingCart)实体类
 *
 * @author makejava
 * @since 2023-04-19 08:24:45
 */
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 939843523908833628L;
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
     * 商品数量
     */
    private Integer num;
    /**
     * 用户id
     */
    private Integer uid;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}

