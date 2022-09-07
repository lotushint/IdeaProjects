package com.lotushint.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lotushint.mybatisplus.mapper.UserMapper;
import com.lotushint.mybatisplus.pojo.User;
import com.lotushint.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 10:10
 * @package com.lotushint.mybatisplus.service.impl
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
