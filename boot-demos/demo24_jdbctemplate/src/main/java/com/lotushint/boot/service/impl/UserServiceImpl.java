package com.lotushint.boot.service.impl;

import com.lotushint.boot.dao.IUserDao;
import com.lotushint.boot.domain.Users;
import com.lotushint.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:53
 * @package com.lotushint.boot.service.impl
 * @description
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int add(Users user) {
        return userDao.add(user);
    }

    @Override
    public int update(Users user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public Users findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<Users> findUserList() {
        return userDao.findUserList();
    }

}
