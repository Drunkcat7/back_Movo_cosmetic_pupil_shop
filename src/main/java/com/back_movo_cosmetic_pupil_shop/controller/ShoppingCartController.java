package com.back_movo_cosmetic_pupil_shop.controller;

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

    /*
    *     <insert id="insert" keyProperty="cartId" useGeneratedKeys="true">
        insert into shopping_cart(g_type_id, num, uid)
        values (#{gTypeId}, #{num}, #{uid})
    </insert>
    *
    * */
    @PostMapping("/user/addGood")
    public Map<String, Object> addCartItem(ShoppingCart shoppingCart, @CurrentUser CurrentUserInfo user) {
        Map<String, Object> map = new HashMap<>();
        shoppingCart.setUid(user.getUid());
        Boolean isAdd = this.shoppingCartService.insert(shoppingCart);
        if (isAdd) {
            map.put("status", 200);
            map.put("msg", "添加成功");
        } else {
            map.put("status", 500);
            map.put("msg", "添加失败");
        }
        return map;
    }

}

