package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2023-04-19 10:40:05
 */
public interface OrderService {


    /**
     * 查询 订单管理 数据
     * @return 对象列表
     */
    List<OrderItem> queryOrderManageAll();

    /** ——-——————————-————--婚戒线————-----——*/

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Order queryById(Integer orderId);

}
