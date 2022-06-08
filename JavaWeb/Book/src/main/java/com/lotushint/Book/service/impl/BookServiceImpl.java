package com.lotushint.Book.service.impl;

import com.lotushint.Book.dao.BookDao;
import com.lotushint.Book.dao.impl.BookDaoImpl;
import com.lotushint.Book.pojo.Book;
import com.lotushint.Book.service.BookService;

import java.util.List;

/**
 * @author hefan
 * @package com.lotushint.Book.service.impl
 * @date 2021/11/25 11:47
 * @description
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBookById(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void queryBookById(Integer id) {
        bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return null;
    }
}
