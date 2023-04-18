package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.Goods;
import com.back_movo_cosmetic_pupil_shop.dao.GoodsDao;
import com.back_movo_cosmetic_pupil_shop.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2023-04-18 14:12:17
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer goodId) {
        return this.goodsDao.queryById(goodId);
    }

    /**
     * 分类页-根据class_id(类别id) 查询
     * @return 对象列表
     */
    @Override
    public List<Goods> queryByClassId(Integer classId) {
        return this.goodsDao.queryAllGoods(classId);
    }

    /**
     * 首页-查询商品表全部数据
     *
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllGoods() {
        return this.goodsDao.queryAllGoods();
    }

    /**
     * 通过主键删除数据
     *
     * @param goodId 主键
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteById(Integer goodId) {
        int i = this.goodsDao.deleteById(goodId);
        return i != 0;
    }


}
