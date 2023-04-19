package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUser;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUserInfo;
import com.back_movo_cosmetic_pupil_shop.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2023-04-19 10:40:05
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderService.queryById(id));
    }

    /**
     * 提交订单
     *
     * @param priceSum     总价
     * @param addressId    地址id
     * @param orderDetails 订单详情
     * @param user         token解析的用户信息
     * @return map
     */
    @PostMapping("/user/submit")
    public Map<String, Object> submit(Integer priceSum, Integer addressId, List<OrderDetail> orderDetails,
                                      @CurrentUser CurrentUserInfo user) {
        /*
         *  添加Order表的数据
         * 循环添加orderDetails表的数据
         *
         * */
        return null;
    }
}

