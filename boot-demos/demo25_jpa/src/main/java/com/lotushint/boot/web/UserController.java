package com.lotushint.boot.web;

import com.lotushint.boot.domain.User;
import com.lotushint.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 11:31
 * @package com.lotushint.boot.web
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * 注意:记得添加@RequestBody注解,否则前端传递来的json数据无法被封装到User中!
     */
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return  userRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "success";
    }

}
