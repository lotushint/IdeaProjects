package com.lotushint.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/13 14:53
 * @package com.lotushint.boot.web
 * @description
 */

/**
 * Spring Boot中支持jsp功能的实现
 */
@Controller
public class JspController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "跟一一哥学习SpringBoot中使用JSP功能!");
        //要跳转到的页面视图名称
        return "index";
    }

}
