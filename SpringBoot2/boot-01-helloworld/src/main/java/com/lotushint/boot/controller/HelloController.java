package com.lotushint.boot.controller;

import com.lotushint.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/9 16:11
 * @package com.lotushint.boot.controller
 * @description
 */
//@ResponseBody
//@Controller
@RestController
@Slf4j
public class HelloController {
    @Autowired
    Car car;


    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01() {
        log.info("请求进来了....");
        return "Hello, Spring Boot 2!" + "你好";
    }
}
