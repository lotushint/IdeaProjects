package com.lotushint.boot.dao;

import com.lotushint.boot.domain.Users;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:50
 * @package com.lotushint.boot.dao
 * @description
 */
public interface IUserDao {

    int add(Users student);

    int update(Users student);

    int delete(int id);

    Users findUserById(int id);

    List<Users> findUserList();

}
