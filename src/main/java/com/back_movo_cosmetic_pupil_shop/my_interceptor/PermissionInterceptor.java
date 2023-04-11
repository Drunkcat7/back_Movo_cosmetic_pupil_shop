package com.back_movo_cosmetic_pupil_shop.my_interceptor;

import com.alibaba.fastjson.JSONObject;
import com.back_movo_cosmetic_pupil_shop.tools.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 用户拦截器
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //首选判断token是否有效
        if (!JwtUtil.checkToken(request)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JSONObject res = new JSONObject();
            res.put("status", 500);
            res.put("msg", "token有误");
            response.getWriter().append(res.toString());
            return false;
        }
        //解密
        CurrentUserInfo userInfo = JwtUtil.getUserIdByJwtToken(request);
        assert userInfo != null;
        request.setAttribute("currentUserInfo", userInfo);
        return true;
    }

}

