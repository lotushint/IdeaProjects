package com.lotushint.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/15 10:07
 * @package com.lotushint.boot.config
 * @description 代码方式自定义资源位置
 */
//@Configuration
//public class MyWebMvcConfig extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //将所有C:\Users\hefan\OneDrive\图片\Saved Pictures目录下的资源,访问时都映射到/res/** 路径下
//        registry.addResourceHandler("/res/**")
//                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/",
//                        "classpath:/static/", "classpath:/public/", "file:C:/Users/hefan/OneDrive/图片/Saved Pictures/");
//    }
//
//}
