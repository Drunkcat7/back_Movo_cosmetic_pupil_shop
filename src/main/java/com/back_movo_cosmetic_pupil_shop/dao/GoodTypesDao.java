package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.GoodTypes;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (GoodTypes)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-18 23:16:36
 */
public interface GoodTypesDao {
    /**
     * 查询商品所属的商品种类
     *
     * @param goodId 商品id
     * @return GoodTypes实体类
     */
    List<GoodTypes> queryGoodItems(@Param("goodId") Integer goodId);
}

