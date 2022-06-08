package com.lotus.spring5.test;

import com.lotus.spring5.config.TxConfig;
import com.lotus.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hefan
 * @package com.lotus.spring5.test
 * @date 2021/9/27 19:44
 * @description
 */
public class TestBook {
    @Test
    public void testAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        /**
         * 第一个参数小写u
         */
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testAccount1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        /**
         * 第一个参数小写u
         */
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testAccount2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        /**
         * 第一个参数小写u
         */
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
