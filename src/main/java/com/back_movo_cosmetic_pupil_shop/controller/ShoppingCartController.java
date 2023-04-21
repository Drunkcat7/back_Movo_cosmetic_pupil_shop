package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.CartItem;
import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUser;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUserInfo;
import com.back_movo_cosmetic_pupil_shop.service.ShoppingCartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ShoppingCart)表控制层
 *
 * @author makejava
 * @since 2023-04-19 08:24:45
 */
@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ShoppingCart> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.shoppingCartService.queryById(id));
    }

    @PostMapping("/user/addGood")
    public Map<String, Object> addCartItem(ShoppingCart shoppingCart, @CurrentUser CurrentUserInfo user) {
        shoppingCart.setUid(user.getUid());
        return this.shoppingCartService.addCart(shoppingCart);
    }

    /**
     * 查询用户所属的购物车
     *
     * @param user token解析的用户信息
     * @return 购物车list
     */
    @GetMapping("/user/myShoppingCart")
    public List<CartItem> myShoppingCart(@CurrentUser CurrentUserInfo user) {
        return this.shoppingCartService.queryByUidAll(user.getUid());
    }

    /**
     * 修改商品数量
     *
     * @param cartId   主键
     * @param num      数量
     * @param userInfo token解析的用户信息
     * @return 信息
     */
    @GetMapping("/user/updateGoodNum")
    public Map<String, Object> updateGoodNum(Integer cartId, Integer num, @CurrentUser CurrentUserInfo userInfo) {
        Map<String, Object> map = new HashMap<>();
        Boolean isUpdate = this.shoppingCartService.updateCartNum(cartId, num, userInfo.getUid());
        if (isUpdate) {
            map.put("status", 200);
            map.put("msg", "修改成功");
        } else {
            map.put("status", 500);
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 通过主键删除商品
     *
     * @param cartId   主键
     * @param userInfo token解析的用户信息
     * @return 信息
     */
    @GetMapping("/user/delGood")
    public Map<String, Object> delGood(Integer cartId, @CurrentUser CurrentUserInfo userInfo) {
        Map<String, Object> map = new HashMap<>();
        Boolean isUpdate = this.shoppingCartService.delGood(cartId, userInfo.getUid());
        if (isUpdate) {
            map.put("status", 200);
            map.put("msg", "删除成功");
        } else {
            map.put("status", 500);
            map.put("msg", "删除失败");
        }
        return map;
    }
}

