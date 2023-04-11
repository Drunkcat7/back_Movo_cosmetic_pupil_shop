package com.back_movo_cosmetic_pupil_shop.my_interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * 拦截器的配置器
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource    //普通用户
    private PermissionInterceptor interceptor;
    @Resource    //管理员
    private PermissionInterceptorAdmin interceptorAdmin;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**/user/**");
        registry.addInterceptor(interceptorAdmin).addPathPatterns("/**/admin/**");

    }

    /*参数解析*/
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserMethodArgumentResolver());
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }
}
