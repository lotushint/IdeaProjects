package com.lotushint.Book.test;

import com.lotushint.Book.dao.UserDao;
import com.lotushint.Book.dao.impl.UserDaoImpl;
import com.lotushint.Book.pojo.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hefan
 * @package com.lotushint.Book.test
 * @date 2021/10/24 13:17
 * @description
 */
class UserDaoTest {

    @AfterEach
    void tearDown() {
        System.out.println("end one");
    }

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin1234") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"lotushint", "123456", "3270025752@qq.com")) );
    }
}