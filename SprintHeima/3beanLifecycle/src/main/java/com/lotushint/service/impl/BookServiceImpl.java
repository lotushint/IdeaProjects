package com.lotushint.service.impl;

import com.lotushint.dao.BookDao;
import com.lotushint.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.service.impl
 * @description
 */
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private BookDao bookDao;

    @Override
    public void save() {
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        System.out.println("set....");
        this.bookDao = bookDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
