package com.lotushint.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hefan
 * @package com.lotushint.mvc.controller
 * @date 2021/11/9 15:18
 * @description
 */
@Controller
public class JspController {
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
