package com.lotushint.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 14:17
 * @package com.lotushint.boot
 * @description
 */
@SpringBootApplication
//@MapperScan("com.lotushint.boot.mapper")//DbConfig类和这都可以使用@MapperScan注解
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }
}
