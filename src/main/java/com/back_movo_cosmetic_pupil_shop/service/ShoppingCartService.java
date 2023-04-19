package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ShoppingCart)表服务接口
 *
 * @author makejava
 * @since 2023-04-19 08:24:45
 */
public interface ShoppingCartService {

    /**
     * 新增数据
     *
     * @param shoppingCart 实例对象
     * @return 影响行数
     */
    Boolean insert(ShoppingCart shoppingCart);



    /**
     * 通过ID查询单条数据
     *
     * @param cartId 主键
     * @return 实例对象
     */
    ShoppingCart queryById(Integer cartId);

}
