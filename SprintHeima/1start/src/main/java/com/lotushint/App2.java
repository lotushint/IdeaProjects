package com.lotushint;

import com.lotushint.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:36
 * @package com.lotushint
 * @description
 */
public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

        System.out.println("测试 name:别名");
        BookService bookService1 = (BookService) ctx.getBean("service");
        BookService bookService2 = (BookService) ctx.getBean("service2");
        BookService bookService3 = (BookService) ctx.getBean("lotushintService");
        bookService1.save();
        bookService2.save();
        bookService3.save();
    }
}
