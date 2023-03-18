package com.lotushint.dao.impl;

import com.lotushint.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.dao.impl
 * @description
 */
@Repository("bookDao2")
@Scope("singleton")
public class BookDaoImpl2 implements BookDao {
    // @Value("2") 为什么不直接用 number = 2？
    // 有可能这个值来自于配置文件
//    @Value("2")
//    private int number;

    @Value("${password}")
    private int number;

    public void save() {
        System.out.println("book save " + number);
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
