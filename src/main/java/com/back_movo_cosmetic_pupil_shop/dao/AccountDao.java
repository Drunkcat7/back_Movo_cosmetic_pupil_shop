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
     * @param user
     * @param password
     * @return
     */
    Account login(@Param("user") String user, @Param("password") String password);

}

