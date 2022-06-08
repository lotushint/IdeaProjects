package com.lotushint.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/15 13:34
 * @package com.lotushint.boot.web
 * @description
 */
@Controller
public class WelcomeController {

    /**
     * produces="application/json;charset=UTF-8":解决继承WebMvcConfigurationSupport类时中文乱码的问题.
     */
    @ResponseBody
    @GetMapping(value="/show",produces="application/json;charset=UTF-8")
    public String showMsg() {
        return "URL路径访问规则";
    }

}
