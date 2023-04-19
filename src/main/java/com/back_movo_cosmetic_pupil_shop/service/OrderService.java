package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.Order;
import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import com.back_movo_cosmetic_pupil_shop.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

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

    /**
     * 提交订单
     *
     * @param order
     * @param orderDetails
     * @return
     */
    Map<String, Object> submit(Order order, List<OrderDetail> orderDetails);

    /** ——-——————————-————--婚戒线————-----——*/

}
