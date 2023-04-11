package com.itheima.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/11 11:47
 * @package com.itheima.reggie
 * @description
 */
@Slf4j
@SpringBootApplication
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class, args);
        // 加上 @Slf4j 就可以使用
        log.info("项目启动成功......");
    }
}
