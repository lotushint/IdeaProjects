package com.lotushint.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 以注解方式整合SSM.
 * MapperScan:扫描Mybatis接口文件
 */
@MapperScan("com.lotushint.boot.mapper")
@SpringBootApplication
public class SSM2Application {

    public static void main(String[] args) {
        SpringApplication.run(SSM2Application.class, args);
    }

}
