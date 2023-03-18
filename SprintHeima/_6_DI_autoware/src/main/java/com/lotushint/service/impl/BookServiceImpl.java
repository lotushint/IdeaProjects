package com.lotushint.service.impl;

import com.lotushint.dao.BookDao;
import com.lotushint.dao.UserDao;
import com.lotushint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.service.impl
 * @description
 */
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        bookDao.save();
        userDao.save();
    }
}
