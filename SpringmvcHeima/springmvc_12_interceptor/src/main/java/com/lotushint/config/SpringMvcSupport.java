package com.lotushint.config;

import com.lotushint.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/13 21:53
 * @package com.lotushint.config
 * @description
 */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //"/books"拦截不了/books/1
//        registry.addInterceptor(projectInterceptor).addPathPatterns("/books");
        //"/books/*"可以拦截/books/1
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
