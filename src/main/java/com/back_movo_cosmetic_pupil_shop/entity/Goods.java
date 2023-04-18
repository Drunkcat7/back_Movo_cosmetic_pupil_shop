package com.back_movo_cosmetic_pupil_shop.entity;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2023-04-18 14:12:17
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -90734894021395938L;
    /**
     * 商品id
     */
    private Integer goodId;
    /**
     * 商品名
     */
    private String gname;
    /**
     * 商品介绍
     */
    private String introduce;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品主图=>商品外部展示的缩略图
     */
    private String mainImg;
    /**
     * 顶图
     */
    private String topImg;
    /**
     * 商品详情轮播图
     */
    private String shufflingFigure;
    /**
     * 底图
     */
    private String bottomImg;
    /**
     * 商品详情图
     */
    private String detailsFigure;
    /**
     * 商品分类id
     */
    private Integer classId;


    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getTopImg() {
        return topImg;
    }

    public void setTopImg(String topImg) {
        this.topImg = topImg;
    }

    public String getShufflingFigure() {
        return shufflingFigure;
    }

    public void setShufflingFigure(String shufflingFigure) {
        this.shufflingFigure = shufflingFigure;
    }

    public String getBottomImg() {
        return bottomImg;
    }

    public void setBottomImg(String bottomImg) {
        this.bottomImg = bottomImg;
    }

    public String getDetailsFigure() {
        return detailsFigure;
    }

    public void setDetailsFigure(String detailsFigure) {
        this.detailsFigure = detailsFigure;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

}

