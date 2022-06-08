package com.lotus.spring5.test;

import com.lotus.spring5.aopanno.User;
import com.lotus.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hefan
 * @package com.lotus.spring5.test
 * @date 2021/8/26 11:49
 * @description
 */
public class testAop {
    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }

    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
