package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/4 18:20
 * @package com.itheima.service
 * @description
 */
public interface UserDao {
    User findByUsername(String username);
}
