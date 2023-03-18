package com.lotushint.service.impl;

import com.lotushint.dao.BookDao;
import com.lotushint.service.BookService;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.service.impl
 * @description
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Override
    public void save() {
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
