package com.lotushint.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 9:40
 * @package com.lotushint.boot
 * @description
 * 以XML方式整合SSM.
 * MapperScan:扫描Mybatis接口文件
 */
@MapperScan("com.lotushint.boot.mapper")
@SpringBootApplication
public class SSMApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSMApplication.class, args);
    }

}
