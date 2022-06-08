package com.lotushint.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

import java.io.File;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/15 10:56
 * @package com.lotushint.boot.config
 * @description
 * WebMvcConfigurerAdapter:从 5.0 开始， WebMvcConfigurer具有默认方法（通过 Java 8 基线实现），无需此适配器即可直接实现
 */
//@Configuration
public class DefaultViewConfig implements WebMvcConfigurer {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //这里的"/"是访问路径，"forward:home.html"是请求转发到的页面名称
//        registry.addViewController("/").setViewName("forward:home.html");
//        //设置优先级
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //本地文件上传路径,前面是请求资源的路径，后面是磁盘中的实际路径。
        registry.addResourceHandler("/res/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/");
    }
}
