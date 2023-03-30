package com.lotushint.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/19 20:20
 * @package com.lotushint.controller
 * @description
 */
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @Value("${country}")
    String country;
    @Value("${user.name1}") //如果使用user.name会输出电脑用户名
    String name;

    @Value("${likes[1]}")
    String likes;

    @GetMapping
    public String getById() {
        System.out.println("spring is running...");
        System.out.println("country=====>" + country);
        System.out.println("name=====>" + name);
        System.out.println("name=====>" + likes);
        return "spring is running...";
    }
}
