package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;

@Data
public class UserOrder {
    /**
     * uid
     */
    private Integer uid;

    private String user;
    /**
     * 订单id
     */
    private Integer orderId;
}
