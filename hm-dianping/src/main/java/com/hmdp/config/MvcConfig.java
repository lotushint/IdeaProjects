package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import com.hmdp.utils.RefreshTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/13 21:23
 * @package com.hmdp.config
 * @description
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // order()优先级值越小越先执行，也可以调整拦截器加入的顺序
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
                "/user/code", "/user/login", "/blog/hot",
                "/shop/**", "/shop-type/**", "/upload/**",
                "/voucher/**"
        ).order(1);
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate)).addPathPatterns("/**").order(0);
    }
}
