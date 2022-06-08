package com.lotus.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hefan
 * @package com.lotus.spring5.dao
 * @date 2021/8/19 8:35
 * @description
 */
@Repository(value="userDaoImpl1")
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("dao add......");
    }
}
