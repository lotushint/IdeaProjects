package com.lotushint.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/9 16:11
 * @package com.lotushint.boot
 * @description   主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
 */
@RestController
public class WorldController {

    @RequestMapping("/w")
    public String world66() {
        return "World";
    }
}
