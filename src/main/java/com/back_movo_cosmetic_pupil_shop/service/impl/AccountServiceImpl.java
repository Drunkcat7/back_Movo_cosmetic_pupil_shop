package com.back_movo_cosmetic_pupil_shop.service.impl;

import com.back_movo_cosmetic_pupil_shop.entity.Account;
import com.back_movo_cosmetic_pupil_shop.dao.AccountDao;
import com.back_movo_cosmetic_pupil_shop.service.AccountService;
import com.back_movo_cosmetic_pupil_shop.tools.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account insert(Account account) {
        this.accountDao.insert(account);
        return account;
    }

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 登录成功的用户
     */
    @Override
    public Map<String, Object> login(String user, String password) {
        Map<String, Object> map = new HashMap<>();
        Account loginUser = this.accountDao.login(user, password);
        if (loginUser == null) return null;
        map.put("uid", loginUser.getUid());
        map.put("user", loginUser.getUser());
        //登录成功生成token
        String token = JwtUtil.getJwtToken(loginUser.getUid(), loginUser.getUser(), loginUser.getLevel());
        map.put("token", token);
        return map;
    }


    /**
     * 查询全部用户
     *
     * @return 用户list
     */
    @Override
    public List<Account> queryUserAll() {
        return this.accountDao.queryUserAll();
    }

    /**
     * 修改用户信息
     *
     * @param account
     * @return 影响行数
     */
    @Override
    public Account update(Account account) {
        int count = this.accountDao.update(account);
        if (count == 0) {
            return null;
        }
        return this.accountDao.queryById(account.getUid());
    }

    /**
     * 通过uid删除用户
     *
     * @param uid
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer uid) {
        int i = this.accountDao.deleteById(uid);
        return i != 0;
    }

}
