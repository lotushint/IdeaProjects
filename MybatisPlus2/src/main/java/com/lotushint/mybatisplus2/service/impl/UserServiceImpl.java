package com.lotushint.mybatisplus2.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lotushint.mybatisplus2.mapper.UserMapper;
import com.lotushint.mybatisplus2.pojo.User;
import com.lotushint.mybatisplus2.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 20:20
 * @package com.lotushint.mybatisplus2.pojo
 * @description
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
