package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.Classification;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Classification)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-20 13:35:24
 */
public interface ClassificationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param classId 主键
     * @return 分类名称
     */
    String queryNameById(Integer classId);

    /**
     * 查询所有分类信息
     * @return
     */
    List<Classification> queryClassAll();



}

