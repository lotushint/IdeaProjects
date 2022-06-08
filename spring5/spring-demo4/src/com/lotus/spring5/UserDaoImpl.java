package com.lotus.spring5;


/**
 * @author hefan
 * @package com.lotus.spring5
 * @date 2021/8/21 15:00
 * @description
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了......");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行了......");
        return id;
    }
}
