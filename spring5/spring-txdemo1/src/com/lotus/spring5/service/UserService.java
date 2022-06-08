package com.lotus.spring5.service;

import com.lotus.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hefan
 * @package com.lotus.spring5.service
 * @date 2021/10/2 13:32
 * @description
 */

/**
 * （1）@Transactional，这个注解添加到类上面，也可以添加方法上面
 * （2）如果把这个注解添加类上面，这个类里面所有的方法都添加事务
 * （3）如果把这个注解添加方法上面，为这个方法添加事务
 */
@Service
@Transactional(readOnly = false,timeout = -1,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {
    /**
     * 注入 dao
     */
    @Autowired
    private UserDao userDao;

    /**
     * 转账的方法
     */
    public void accountMoney() {
//        try{
            //第一步开启事务
            //第二步进行业务操作
            //lucy 少 100
            userDao.reduceMoney();

            //模拟异常
            int i = 10/0;

            //mary 多 100
            userDao.addMoney();
            //第三步没有发生异常提交事务
//        }catch(Exception e){
//            //第四步出现异常，事务回滚
//        }
    }
}
