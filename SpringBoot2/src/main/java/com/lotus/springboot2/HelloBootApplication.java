package com.lotus.springboot2;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 10:28
 * @package com.lotus.springboot2
 * @description
 */

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot启动类,定义了一个"/"访问接口
 */
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})/**入口类是包含@SpringBootApplication注解和main方法的类*/
public class HelloBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }

    @RequestMapping("/")
    String hello() {
        return "Hello Spring Boot2!";
    }

}
