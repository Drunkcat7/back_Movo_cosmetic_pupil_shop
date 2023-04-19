package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.CartItem;
import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import com.back_movo_cosmetic_pupil_shop.dao.ShoppingCartDao;
import com.back_movo_cosmetic_pupil_shop.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 通过uid查询该用户所属的商品
     *
     * @param uid 用户id
     * @return 实例集合
     */
    @Override
    public List<CartItem> queryByUidAll(Integer uid) {
        return this.shoppingCartDao.queryByUidAll(uid);
    }

    /**
     * 通过主键修改商品数量
     *
     * @param cartId 主键
     * @param num    商品数量
     * @return 是否修改成功
     */
    @Override
    public Boolean updateCartNum(Integer cartId, Integer num, Integer uid) {
        int isUpdate = this.shoppingCartDao.updateCartNum(cartId, num, uid);
        return isUpdate != 0;
    }


    /**
     * 删除购物车的商品信息
     *
     * @param cartId 主键
     * @param uid    用户信息
     * @return 是否删除
     */
    @Override
    public Boolean delGood(Integer cartId, Integer uid) {
        int i = this.shoppingCartDao.deleteById(cartId, uid);
        return i != 0;
    }

}
