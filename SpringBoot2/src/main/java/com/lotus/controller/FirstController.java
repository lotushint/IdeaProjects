package com.lotus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 11:22
 * @package com.lotus.controller
 * @description
 */
@RestController
public class FirstController {
    @GetMapping("/hi")
    public String showMsg(){
        return "Hello,lotus";
    }
}
