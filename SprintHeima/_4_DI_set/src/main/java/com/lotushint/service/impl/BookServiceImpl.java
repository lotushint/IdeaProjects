package com.lotushint.service.impl;

import com.lotushint.dao.BookDao;
import com.lotushint.dao.UserDao;
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
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    private UserDao userDao;

    @Override
    public void save() {
        bookDao.save();
        userDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
