package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.dao.OrderDetailDao;
import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.dao.OrderDao;
import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import com.back_movo_cosmetic_pupil_shop.entity.UserOrder;
import com.back_movo_cosmetic_pupil_shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2023-04-19 10:40:05
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private OrderDetailDao orderDetailDao;

    @Override
    public List<Map<String, Object>> queryOrderManageAll(Integer uid) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<UserOrder> userOrders = this.orderDao.queryOrderIdByUid(uid);
        List<OrderItem> orderItems = this.orderDao.queryOrderManageAll();
        for (UserOrder userOrder : userOrders) {
            Map<String, Object> mapOrder = new HashMap<>();
            List<OrderItem> collect = orderItems.stream()
                    .filter(order -> Objects.equals(order.getOrderId(), userOrder.getOrderId()))
                    .collect(Collectors.toList());
            mapOrder.put("oderId", userOrder.getOrderId());
            mapOrder.put("uid", userOrder.getUid());
            mapOrder.put("user", userOrder.getUser());
            try {
                mapOrder.put("productStatus", collect.get(0).getProductStatus());
            } catch (Exception e) {
                mapOrder.put("productStatus", null);
            }
            mapOrder.put("orderItem", collect);
            list.add(mapOrder);
        }
        return list;
    }

    /** -------------分界线------------- */

    /**
     * 提交订单
     *
     * @param order
     * @param orderDetails
     * @return
     */
    @Override
    public Map<String, Object> submit(Order order, List<OrderDetail> orderDetails) {
        Map<String, Object> map = new HashMap<>();
        try {
            //添加Order表的数据
            this.orderDao.insert(order);
            //System.out.println("uid" + order.getUid());
            Integer orderId = this.orderDao.queryLastOrderByUid(order.getUid());

            //循环添加orderDetails表的数据
            for (OrderDetail orderDetail : orderDetails) {
                orderDetail.setOrderId(orderId);
                this.orderDetailDao.insert(orderDetail);
            }
            map.put("status", 200);
            map.put("orderId", orderId);
            map.put("msg", "提交订单成功");
        } catch (Exception e) {
            map.put("status", 500);
            map.put("msg", "提交订单失败");
            System.out.println(e.getMessage());
            return map;
        }
        return map;
    }

    /**
     * 更改订单状态
     *
     * @param orderId
     * @return
     */
    @Override
    public Boolean changeOrderStatus(Integer orderId, int changeStatusNum) {
        Integer orderStatus = this.orderDao.queryOrderStatusById(orderId);
        if (changeStatusNum - 1 != orderStatus) {
            //1跳到3可以，代发货可以直接跳转到待评价
            if (!(orderStatus == 1 && changeStatusNum == 3)) {
                return false;
            }
        }
        Order order = new Order();
        order.setOrderId(orderId);
        order.setProductStatus(changeStatusNum);
        this.orderDao.updateOrderStatusById(order);
        return true;
    }
}
