package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.AppOrder;
import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUser;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUserInfo;
import com.back_movo_cosmetic_pupil_shop.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
     * 提交订单
     *
     * @param appOrder==>包含订单,和订单详情 订单==> priceSum, addressId
     * @param user                  token解析的用户信息
     * @return map
     */
    @PostMapping("/user/submit")
    public Map<String, Object> submit(@RequestBody AppOrder appOrder, @CurrentUser CurrentUserInfo user) {
        Order order = new Order();
        order.setPriceSum(appOrder.getPriceSum());
        order.setAddressId(appOrder.getAddressId());
        order.setUid(user.getUid());
        order.setProductStatus(0);
        return this.orderService.submit(order, appOrder.getOrderDetails());
    }

    @GetMapping("/admin/queryOrder")
    public Map<String,Object> queryOrderManageAll(@CurrentUser CurrentUserInfo user){
        List<OrderItem> orderItemList = this.orderService.queryOrderManageAll();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("adminName",user.getUser());
        map.put("orderItemList",orderItemList);
        return map;
    }


    /**
     * 待发货
     * @param orderId
     * @return
     */
    @GetMapping("/user/deliverGoods")
    public Boolean deliverGoods(Integer orderId){
        return this.orderService.changeOrderStatus(orderId,1);
    }

    /**
     * 待评价
     * @param orderId
     * @return
     */
    @GetMapping("/user/evaluate")
    public Boolean evaluate(Integer orderId){
        return this.orderService.changeOrderStatus(orderId,3);
    }

    /**
     * 待收货
     * @param orderId
     * @return
     */
    @GetMapping("/admin/receiving")
    public Boolean receiving(Integer orderId){
        return this.orderService.changeOrderStatus(orderId,2);
    }

}

