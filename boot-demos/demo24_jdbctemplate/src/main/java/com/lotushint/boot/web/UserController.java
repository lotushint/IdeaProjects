package com.lotushint.boot.web;

import com.lotushint.boot.domain.Users;
import com.lotushint.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:55
 * @package com.lotushint.boot.web
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("")
    public int addUser(@RequestBody Users user){
        return iUserService.add(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody Users user){
        Users oldUser = new Users();
        oldUser.setId(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        int t = iUserService.update(oldUser);
        if (t == 1){
            return user.toString();
        }else {
            return "更新学生信息错误";
        }
    }

    @GetMapping("/{id}")
    public Users findUserById(@PathVariable Integer id){
        return iUserService.findUserById(id);
    }

    @GetMapping("/list")
    public List<Users> findUserList(){
        return iUserService.findUserList();
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable Integer id){
        return iUserService.delete(id);
    }

}
