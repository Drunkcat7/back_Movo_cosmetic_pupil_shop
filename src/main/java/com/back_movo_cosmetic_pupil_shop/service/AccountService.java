package com.back_movo_cosmetic_pupil_shop.service;

import com.back_movo_cosmetic_pupil_shop.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
public interface AccountService {


    /**
     * 新增数据==>用户注册
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 登录的对象
     */
    Map<String, Object> login(String user, String password);

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
    Account update(Account account);

    /**
     * 通过uid删除用户
     * @param uid
     * @return 是否成功
     */
    Boolean deleteById(Integer uid);

}
