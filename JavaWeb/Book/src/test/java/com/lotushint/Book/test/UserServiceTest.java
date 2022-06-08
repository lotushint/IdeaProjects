package com.lotushint.Book.test;

import com.lotushint.Book.pojo.User;
import com.lotushint.Book.service.UserService;
import com.lotushint.Book.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hefan
 * @package com.lotushint.Book.test
 * @date 2021/10/24 13:38
 * @description
 */
class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "lotushint", "123456", "3270025752@qq.com")) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("lotushint")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}