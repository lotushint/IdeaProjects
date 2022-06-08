package com.hint.demo01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hefan
 * @package com.hint.demo01
 * @date 2021/10/15 3:24
 * @description
 */
@RestController
public class FirstController {
    @GetMapping("/hi")
    public String showMSG(){
        return "Hello lotushint!";
    }
}
