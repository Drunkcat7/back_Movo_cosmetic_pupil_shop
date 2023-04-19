package com.back_movo_cosmetic_pupil_shop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-04-19 10:46:50
 */
@Data
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
    @JsonProperty(value = "gTypeId")
    private Integer gTypeId;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品数量
     */
    private Integer num;

}

