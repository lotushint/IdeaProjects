package com.lotushint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/11/20 15:03
 * @package com.lotushint
 * @description
 */
@SpringBootApplication
//@MapperScan("com.lotushint.mapper")
public class EpidemicApplication {
    public static void main(String[] args) {
        SpringApplication.run(EpidemicApplication.class, args);
    }
}
