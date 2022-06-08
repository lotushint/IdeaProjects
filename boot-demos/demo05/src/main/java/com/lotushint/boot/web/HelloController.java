package com.lotushint.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/12 15:20
 * @package com.lotushint.controller
 * @description
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 添加一个属性,用来在模板中根据这个key来读取对应的值
        map.addAttribute("msg", "跟一一哥学习SpringBoot");
        // return 模板文件的名称-->对应src/main/resources/templates/index.html
        return "index";
    }
}
