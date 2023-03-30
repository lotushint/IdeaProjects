package com.lotushint.controller;

import com.lotushint.pojo.User;
import com.lotushint.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //注入Service
//    @Autowired//本地注入

    /*
     1. 从zookeeper注册中心获取userService的访问url
     2. 进行远程调用RPC
     3. 将结果封装为一个代理对象。给变量赋值
     */
    @Reference(cluster = "failover",loadbalance = "random", version = "v2.0", timeout = 1000)//远程注入(在服务消费方配置timeout会覆盖服务提供方——UserServiceImpl的timeout,建议配置在服务提供方)
    private UserService userService;


    @RequestMapping("/sayHello")
    public String sayHello() {
        return userService.sayHello();
    }

    int i = 1;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public User find(int id) {

        /*new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        return userService.findUserById(id);
    }
}

