package com.lotus.service;

import com.lotus.dao.UserDao;

/**
 * @author hefan
 * @package com.lotus.service
 * @date 2021/8/15 9:39
 * @description
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add...................");
        userDao.update();
    }
}
