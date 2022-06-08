package com.lotushint.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/8 9:35
 * @package com.lotushint.mvc.controller
 * @description
 */
@Controller
public class TestController {

    /**
     * 路径ant风格‘**’表示任意的一层或多层目录
     *
     * @return
     */
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 / 0);
        return "success";
    }

}

