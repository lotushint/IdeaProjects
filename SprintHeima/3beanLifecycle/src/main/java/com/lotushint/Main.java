package com.lotushint;


import com.lotushint.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lotushint
 * @version 1.0
 * @date ${DATE} ${TIME}
 * @package com.lotushint
 * @description
 */
public class Main {
    public static void main(String[] args) {
        //要想执行destroy方法，两种方式

        // 1.ApplicationContext--》ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
//        ctx.close();

        // 2.registerShutdownHook
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");
        ctx.registerShutdownHook();
        bookDao2.save();

    }
}