package com.lotus.testdemo;

import com.lotus.bean.Emp;
import com.lotus.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

    @Test
    public void testBean1() {
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        //2 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }
    @Test
    public void testBean2(){
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        //2 获取配置创建的对象
        Emp emp = context.getBean("emp",Emp.class);
        emp.add();
    }
    @Test
    public void testBean3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp = context.getBean("emp",Emp.class);
        emp.add();
    }
}
