package com.lotushint.boot;
/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/12 15:20
 * @package PACKAGE_NAME
 * @description
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 创建web项目
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class,args);
    }

}