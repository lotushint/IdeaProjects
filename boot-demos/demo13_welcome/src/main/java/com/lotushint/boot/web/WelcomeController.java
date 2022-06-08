package com.lotushint.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/15 11:03
 * @package com.lotushint.boot.config
 * @description 把上一个案例中DefaultViewConfig配置类的@Configure注解去掉，避免影响到本次实验。
 */
@Controller
public class WelcomeController {

//    @RequestMapping("/")
//    public String view() {
//        return "forward:home.html";
//    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}