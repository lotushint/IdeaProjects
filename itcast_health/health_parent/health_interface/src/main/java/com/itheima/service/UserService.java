package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/4 18:02
 * @package com.itheima.service
 * @description
 */
public interface UserService {
    User findByUsername(String username);
}
