package com.lotushint.boot.service;

import com.lotushint.boot.domain.Users;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:52
 * @package com.lotushint.boot.service
 * @description
 */
public interface IUserService {

    int add(Users user);

    int update(Users user);

    int delete(int id);

    Users findUserById(int id);

    List<Users> findUserList();

}
