package com.lotushint.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/9 8:47
 * @package com.lotushint.mvc.controller
 * @description
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}

