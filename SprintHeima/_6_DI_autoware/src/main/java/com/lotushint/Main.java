package com.lotushint;

import com.lotushint.dao.BookDao;
import com.lotushint.service.BookService;
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
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookService.save();
        bookDao.save();
    }
}