package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.dao.OrderDetailDao;
import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.dao.OrderDao;
import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import com.back_movo_cosmetic_pupil_shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<OrderItem> queryOrderManageAll() {
        return this.orderDao.queryOrderManageAll();
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
     * @param orderId
     * @return
     */
    @Override
    public Boolean changeOrderStatus(Integer orderId,int changeStatusNum) {
        if (changeStatusNum-1 != this.orderDao.queryOrderStatusById(orderId)){
            return false;
        }
        Order order = new Order();
        order.setOrderId(orderId);
        order.setProductStatus(changeStatusNum);
        this.orderDao.updateOrderStatusById(order);
        return true;
    }
}
