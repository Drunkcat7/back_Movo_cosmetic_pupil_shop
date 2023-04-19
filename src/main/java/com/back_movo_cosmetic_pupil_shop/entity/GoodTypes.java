package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (GoodTypes)实体类
 *
 * @author makejava
 * @since 2023-04-18 23:16:36
 */
public class GoodTypes implements Serializable {
    private static final long serialVersionUID = 310638452556044366L;
    /**
     * 商品种类Id
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
     * 商品id
     */
    private Integer goodId;


    public Integer getGTypeId() {
        return gTypeId;
    }

    public void setGTypeId(Integer gTypeId) {
        this.gTypeId = gTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

}

