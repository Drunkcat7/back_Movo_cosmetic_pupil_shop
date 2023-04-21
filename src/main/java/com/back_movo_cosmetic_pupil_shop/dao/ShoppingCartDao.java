package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.CartItem;
import com.back_movo_cosmetic_pupil_shop.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ShoppingCart)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-19 08:24:45
 */
public interface ShoppingCartDao {

    /**
     * 新增数据
     *
     * @param shoppingCart 实例对象
     * @return 影响行数
     */
    int insert(ShoppingCart shoppingCart);

    /**
     * 添加商品数量
     *
     * @param shoppingCart
     * @return
     */
    int addGoodsNum(ShoppingCart shoppingCart);


    ShoppingCart queryIsGoods(@Param("goodId") Integer goodId, @Param("gTypeId") Integer gTypeId, @Param("uid") Integer uid);


    /**
     * 通过uid查询该用户所属的商品
     *
     * @param uid 用户id
     * @return 实例集合
     */
    List<CartItem> queryByUidAll(@Param("uid") Integer uid);


    /**
     * 通过主键修改商品数量
     *
     * @param cartId 主键
     * @param num    商品数量
     * @return 影响行数
     */
    int updateCartNum(@Param("cartId") Integer cartId, @Param("num") Integer num, @Param("uid") Integer uid);

    /**
     * 通过主键删除数据
     *
     * @param cartId 主键
     * @param uid    用户id
     * @return 影响行数
     */
    int deleteById(@Param("cartId") Integer cartId, @Param("uid") Integer uid);

    /**~===============================================================分界线===============================================================**/


    /**
     * 通过ID查询单条数据
     *
     * @param cartId 主键
     * @return 实例对象
     */
    ShoppingCart queryById(Integer cartId);

    /**
     * 查询指定行数据
     *
     * @param shoppingCart 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<ShoppingCart> queryAllByLimit(ShoppingCart shoppingCart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shoppingCart 查询条件
     * @return 总行数
     */
    long count(ShoppingCart shoppingCart);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShoppingCart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShoppingCart> entities);

    /**
     * 修改数据
     *
     * @param shoppingCart 实例对象
     * @return 影响行数
     */
    int update(ShoppingCart shoppingCart);

}

