package com.hint.demo01;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class HelloBootApplication {

    public static void main(String[] args) {
        //SpringApplication.run(HelloBootApplication.class, args);
        SpringApplication application=new SpringApplication(HelloBootApplication.class);
        //设置banner模式,不需要打印banner可以关闭,默认是开启的
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);
    }

    @RequestMapping("/")
    String hello() {
        return "Hello Spring Boot!";
    }

}
