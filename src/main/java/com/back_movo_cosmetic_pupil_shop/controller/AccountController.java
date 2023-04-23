package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.Account;
import com.back_movo_cosmetic_pupil_shop.service.AccountService;
import com.back_movo_cosmetic_pupil_shop.tools.GetStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2023-04-10 17:21:43
 */
@RestController
@RequestMapping("account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 用户注册
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping("/reg")
    public ResponseEntity<Account> registeredAdd(Account account) {
        return ResponseEntity.ok(this.accountService.insert(account));
    }

    /**
     * 用户登录
     *
     * @param user
     * @param password
     * @return 用户信息与token
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(String user, String password) {
        return ResponseEntity.ok(GetStatus.get(this.accountService.login(user, password)));
    }


    /**
     * 查询全部普通用户
     *
     * @return 返回用户信息
     */
    @GetMapping("/admin/userAll")
    public List<Account> queryUserAll() {
        return this.accountService.queryUserAll();
    }

    /**
     * 修改用户信息
     *
     * @param account
     * @return 修改过后的数据
     */
    @PutMapping("/admin/updateUser")
    public Account updateUser(Account account) {
        return this.accountService.update(account);
    }

    /**
     * 删除用户
     *
     * @param uid
     * @return 删除的信息
     */
    @GetMapping("/admin/delUser")
    public Map<String, Object> delUser(Integer uid) {
        Map<String, Object> map = new HashMap<>();
        Boolean isDel = this.accountService.deleteById(uid);
        if (isDel) {
            map.put("msg", "删除成功");
            map.put("status", 200);
        } else {
            map.put("msg", "删除失败");
            map.put("status", 500);
        }
        return map;
    }

    /**
     * 添加用户
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping("/admin/insertUser")
    public ResponseEntity<Account> insertUser(Account account) {
        return ResponseEntity.ok(this.accountService.insert(account));
    }
}

