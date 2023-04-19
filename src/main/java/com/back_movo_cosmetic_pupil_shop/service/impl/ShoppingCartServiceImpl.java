package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import com.back_movo_cosmetic_pupil_shop.dao.ShoppingCartDao;
import com.back_movo_cosmetic_pupil_shop.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ShoppingCart)表服务实现类
 *
 * @author makejava
 * @since 2023-04-19 08:34:21
 */
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;

    @Override
    public Boolean insert(ShoppingCart shoppingCart) {
        int insert = this.shoppingCartDao.insert(shoppingCart);
        return insert != 0;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param cartId 主键
     * @return 实例对象
     */
    @Override
    public ShoppingCart queryById(Integer cartId) {
        return this.shoppingCartDao.queryById(cartId);
    }
}
