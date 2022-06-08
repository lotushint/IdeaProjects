package com.lotushint.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/13 14:54
 * @package com.lotushint.boot
 * @description
 */
@SpringBootApplication
public class JspApplication  {
    //注意:不要直接启动该类,要以spring-boot:run命令方式启动才行,否则404!!!
    public static void main(String[] args) {
        SpringApplication.run(JspApplication.class, args);
    }
}
