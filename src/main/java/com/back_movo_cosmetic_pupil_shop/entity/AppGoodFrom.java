package com.back_movo_cosmetic_pupil_shop.entity;

import lombok.Data;

import java.util.List;

@Data
public class AppGoodFrom {

    private Goods goods;

    private List<GoodTypes> goodTypesList;
}
