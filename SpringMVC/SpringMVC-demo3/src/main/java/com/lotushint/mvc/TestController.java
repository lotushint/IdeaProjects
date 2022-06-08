package com.lotushint.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hefan
 * @package com.lotushint.mvc
 * @date 2021/11/2 14:22
 * @description
 */
@Controller
public class TestController {
    /**
     * 改为springMVC.xml中
     * <mvc:view-controller path="/" view-name="index"></mvc:view-controller>
     *
     *当SpringMVC中设置任何一个view-controller时，其他控制器中的请求映射将全部失效，
     * 此时需要在SpringMVC的核心配置文件中设置开启mvc注解驱动的标签：
     * <mvc:annotation-driven />
     *
     * @return
     */
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}
