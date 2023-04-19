package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.dao.OrderDao;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import com.back_movo_cosmetic_pupil_shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<OrderItem> queryOrderManageAll() {
        return this.orderDao.queryOrderManageAll();
    }

    /** -------------分界线------------- */

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer orderId) {
        return this.orderDao.queryById(orderId);
    }
}
