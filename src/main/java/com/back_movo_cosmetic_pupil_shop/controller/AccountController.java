package com.back_movo_cosmetic_pupil_shop.controller;

import com.back_movo_cosmetic_pupil_shop.entity.Account;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUser;
import com.back_movo_cosmetic_pupil_shop.my_interceptor.CurrentUserInfo;
import com.back_movo_cosmetic_pupil_shop.service.AccountService;
import com.back_movo_cosmetic_pupil_shop.tools.GetStatus;
import com.back_movo_cosmetic_pupil_shop.tools.JwtUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @GetMapping("/admin/test")
    public Map<String, Object> adminTest(@CurrentUser CurrentUserInfo currentUserInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", currentUserInfo);
        map.put("msg", "admin");
        return map;
    }

    @GetMapping("/user/test")
    public Map<String, Object> UseTest(@CurrentUser CurrentUserInfo currentUserInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", currentUserInfo);
        return map;
    }

}

