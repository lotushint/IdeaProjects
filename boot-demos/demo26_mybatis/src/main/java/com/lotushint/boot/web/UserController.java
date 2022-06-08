package com.lotushint.boot.web;

import com.lotushint.boot.domain.User;
import com.lotushint.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 14:29
 * @package com.lotushint.boot.web
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userMapper.queryUserById(id);
    }

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        userMapper.insertUser(user);
        return "success";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delUserById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
        return "success";
    }

}
