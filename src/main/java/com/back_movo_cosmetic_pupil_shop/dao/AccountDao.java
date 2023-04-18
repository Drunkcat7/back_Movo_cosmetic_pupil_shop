package com.back_movo_cosmetic_pupil_shop.dao;

import com.back_movo_cosmetic_pupil_shop.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
public interface AccountDao {

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 登录者的信息
     */
    Account login(@Param("user") String user, @Param("password") String password);

    /**
     * 查询全部用户
     *
     * @return 用户list
     */
    List<Account> queryUserAll();

    /**
     * 修改用户信息
     *
     * @param account
     * @return 影响行数
     */
    int update(Account account);

    /**
     * 查询单个用户
     * @param uid
     * @return 用户信息
     */
    Account queryById(Integer uid);

    /**
     * 通过uid删除用户
     * @param uid
     * @return 影响行数
     */
    int deleteById(Integer uid);

}

