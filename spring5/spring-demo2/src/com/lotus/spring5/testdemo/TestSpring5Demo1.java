package com.lotus.spring5.testdemo;

import com.lotus.spring5.autowire.Emp;
import com.lotus.spring5.bean.Orders;
import com.lotus.spring5.collectiontype.Book;
import com.lotus.spring5.collectiontype.Course;
import com.lotus.spring5.collectiontype.Stu;
import com.lotus.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hefan
 * @package com.lotus.spring5.testdemo
 * @date 2021/8/17 16:09
 * @description
 */
public class TestSpring5Demo1 {
    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //Stu stu = (Stu) context.getBean("stu");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        //book.test();
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("mybean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testBean3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取创建bean实例对象");
        System.out.println(orders);

        //手动让bean实例销毁
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test4() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
