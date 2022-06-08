package com.lotushint.boot.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lotushint.boot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 11:56
 * @package com.lotushint.boot.web
 * @description
 */
@RestController
public class UserController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object getList() {
        List<User> list = new ArrayList<>();
        //测试字符串有null的情况
        User u1 = new User("一一哥", null);
        list.add(u1);
        return list;
    }

}