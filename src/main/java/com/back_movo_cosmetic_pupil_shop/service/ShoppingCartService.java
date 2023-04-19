package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.CartItem;
import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

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

    /**
     * 通过uid查询该用户所属的商品
     *
     * @param uid 用户id
     * @return 实例集合
     */
    List<CartItem> queryByUidAll(Integer uid);

    /**
     * 通过主键修改商品数量
     *
     * @param cartId 主键
     * @param num    商品数量
     * @return 是否修改成功
     */
    Boolean updateCartNum(Integer cartId, Integer num, Integer uid);

    /**
     * 通过主键删除商品
     *
     * @param cartId 主键
     * @return 是否删除成功
     */
    Boolean delGood(Integer cartId, Integer uid);
}
