package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-19 10:46:50
 */
public interface OrderDetailDao {
    
    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 影响行数
     */
    int insert(OrderDetail orderDetail);

    /** ----------------------分～杰线---------------------- **/

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    OrderDetail queryById(Integer orderId);

    /**
     * 查询指定行数据
     *
     * @param orderDetail 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<OrderDetail> queryAllByLimit(OrderDetail orderDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param orderDetail 查询条件
     * @return 总行数
     */
    long count(OrderDetail orderDetail);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderDetail> entities);

    /**
     * 修改数据
     *
     * @param orderDetail 实例对象
     * @return 影响行数
     */
    int update(OrderDetail orderDetail);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderId);

}

