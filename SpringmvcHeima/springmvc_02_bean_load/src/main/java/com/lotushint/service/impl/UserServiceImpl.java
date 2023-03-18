package com.lotushint.service.impl;

import com.lotushint.domain.User;
import com.lotushint.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public void save(User user) {
        System.out.println("user service ...");
    }
}
