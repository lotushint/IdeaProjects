package com.lotushint.boot.web;

import com.lotushint.boot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 14:08
 * @package com.lotushint.boot.web
 * @description
 */
@Slf4j
@RestController
public class UserController {

    /**
     * 将对象转为json字符串-->序列化
     */
    @GetMapping("/user/{salary}")
    public User home(@PathVariable("salary") Long salary) {
        return new User("一一哥", 30, true, new Date(), "程序员", salary);
    }

    /**
     * 将一个json转化为对象-->反序列化
     */
    @RequestMapping(value = "user")
    public String getValue(@RequestBody User user) {
        log.warn("user=" + user.toString());
        return user.toString();
    }

}