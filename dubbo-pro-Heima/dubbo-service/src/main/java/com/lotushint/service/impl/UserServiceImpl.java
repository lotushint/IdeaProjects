package com.lotushint.service.impl;

import com.lotushint.pojo.User;
import com.lotushint.service.UserService;
import org.apache.dubbo.config.annotation.Service;


//@Service//将该类的对象创建出来，放到Spring的IOC容器中  bean定义

//将这个类提供的方法（服务）对外发布。将访问的地址 ip，端口，路径注册到注册中心中
@Service(version = "v1.0", timeout = 3000, retries = 2)//当前服务 3 秒超时，timeout建议配置在服务提供方；重试 2 次，一共 3 次
public class UserServiceImpl implements UserService {
    int i = 1;

    public String sayHello() {
        return "hello dubbo!~";
    }

    @Override
    public User findUserById(int id) {
        System.out.println("old...");

        User user = new User(1, "zhangsan", "123");
        /*System.out.println("服务被调用了：" + i++);
        //查询User对象
        User user = new User(1, "zhangsan", "123");
        //数据库查询很慢，查了5秒
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return user;
    }
}
