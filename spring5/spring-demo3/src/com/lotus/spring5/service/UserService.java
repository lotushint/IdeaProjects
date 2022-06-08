package com.lotus.spring5.service;

import com.lotus.spring5.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hefan
 * @package com.lotus.spring5.service
 * @date 2021/8/18 10:10
 * @description
 */

//在注解里面value属性值可以省略不写，
//默认值是类名称，首字母小写
//UserService -- userService
//@Component(value = "userService") //<bean id="userService" class=".."/>
//@Service
//@Controller
@Service
public class UserService {

    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解
//    @Autowired  //根据类型进行注入
//    @Qualifier(value="userDaoImpl1")
//    private UserDao userDao;

    //@Resource  //根据类型进行注入
    @Resource(name = "userDaoImpl1")  //根据名称进行注入
    private UserDao userDao;
    public void add(){
        System.out.println("service add.......");
        userDao.add();
    }
}
