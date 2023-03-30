package com.itheima;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/28 14:57
 * @package com.itheima
 * @description
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jobs.xml");
    }
}
