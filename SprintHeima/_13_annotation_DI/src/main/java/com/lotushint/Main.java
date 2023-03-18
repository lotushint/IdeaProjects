package com.lotushint;

import com.lotushint.config.SpringConfig;
import com.lotushint.dao.BookDao;
import com.lotushint.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lotushint
 * @version 1.0
 * @date ${DATE} ${TIME}
 * @package com.lotushint
 * @description
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}