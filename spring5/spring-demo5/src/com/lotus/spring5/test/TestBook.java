package com.lotus.spring5.test;

import com.lotus.spring5.entity.Book;
import com.lotus.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hefan
 * @package com.lotus.spring5.test
 * @date 2021/9/27 19:44
 * @description
 */
public class TestBook {
    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        Book book = context.getBean("book", Book.class);
        bookService.addBook(book);
    }

    @Test
    public void testJdbcTemplate1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        Book book = context.getBean("book", Book.class);
        book.setUserId("dijia");
        bookService.updateBook(book);
    }

    @Test
    public void testJdbcTemplate2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.delete("dijia");
    }

    @Test
    public void testJdbcTemplate3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        int count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void testJdbcTemplate4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        Book book = bookService.findOne("1");
        System.out.println(book);
    }

    @Test
    public void testJdbcTemplate5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3","py","a"};
        Object[] o2 = {"4","py1","a1"};
        Object[] o3 = {"5","py2","a2"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testJdbcTemplate6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"py00","a","3"};
        Object[] o2 = {"py11","a1","4"};
        Object[] o3 = {"py22","a2","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testJdbcTemplate7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        Object[] o3 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }
}
