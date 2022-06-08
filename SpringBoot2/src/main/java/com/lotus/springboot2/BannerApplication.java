package com.lotus.springboot2;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 11:06
 * @package com.lotus.springboot2
 * @description
 */
@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BannerApplication.class, args);
        SpringApplication application=new SpringApplication(BannerApplication.class);
        //设置banner模式,不需要打印banner可以关闭,默认是开启的
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
