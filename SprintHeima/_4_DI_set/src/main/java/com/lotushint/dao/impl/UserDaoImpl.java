package com.lotushint.dao.impl;

import com.lotushint.dao.UserDao;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/4 15:34
 * @package com.lotushint.dao.impl
 * @description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user save");
    }
}
