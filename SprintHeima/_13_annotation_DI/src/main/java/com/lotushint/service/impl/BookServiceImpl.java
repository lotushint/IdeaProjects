package com.lotushint.service.impl;

import com.lotushint.dao.BookDao;
import com.lotushint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.service.impl
 * @description
 */
@Service
public class BookServiceImpl implements BookService {
    //多个同种类型如何注入？

    // 1. @Repository("bookDao"),@Repository("bookDao")
//    @Autowired
//    private BookDao bookDao2;

    // 2.添加 @Qualifier("bookDao2")
    @Autowired
    @Qualifier("bookDao2")
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
}
