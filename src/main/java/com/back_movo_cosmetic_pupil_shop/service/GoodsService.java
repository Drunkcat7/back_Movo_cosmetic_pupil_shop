package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2023-04-18 14:12:17
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodId 主键
     * @return 实例对象
     */
    Goods queryById(Integer goodId);

    /**
     * 分类页-根据class_id(类别id) 查询
     * @return 对象列表
     */
    List<Goods> queryByClassId(Integer classId);


    /**
     * 首页-查询商品表全部数据
     * @return 对象列表
     */
    List<Goods> queryAllGoods();

    /**
     * 通过主键删除数据
     *
     * @param goodId 主键
     * @return 影响行数
     */
    Boolean deleteById(Integer goodId);

}
