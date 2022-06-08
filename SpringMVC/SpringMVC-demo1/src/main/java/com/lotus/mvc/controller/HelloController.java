package com.lotus.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hefan
 * @package com.lotus.mvc.Controller
 * @date 2021/10/14 14:14
 * @description
 */
@Controller
public class HelloController {
    /**
     * // @RequestMapping注解：处理请求和控制器方法之间的映射关系
     * // @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
     * // localhost:8080/springMVC/
     * @return
     */
    @RequestMapping("/")//只为value赋值可省略不写
    public String index() {
        //设置视图名称
        return "index";
    }

    @RequestMapping("/hello")
    public String toHello(){
        return "hello";
    }
}