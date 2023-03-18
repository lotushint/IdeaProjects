package com.lotushint.dao.impl;

import com.lotushint.dao.BookDao;
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
@Repository
@Scope("singleton")
public class BookDaoImpl implements BookDao {

    public void save() {
        System.out.println("book save ");
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
