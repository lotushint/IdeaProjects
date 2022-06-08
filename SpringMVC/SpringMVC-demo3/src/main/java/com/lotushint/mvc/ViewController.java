package com.lotushint.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hefan
 * @package com.lotushint.mvc
 * @date 2021/11/7 20:48
 * @description
 */
@Controller
public class ViewController {

    /**
     * ThymeleafView
     * @return
     */
    @RequestMapping("/testThymeleafView")
    public String testThymeleaf(){
        return "success";
    }

    /**
     * InternalResourceView -> ThymeleafView
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    /**
     * WEB-INF目录不能被重定向访问
     * RedirectView -> ThymeleafView
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
