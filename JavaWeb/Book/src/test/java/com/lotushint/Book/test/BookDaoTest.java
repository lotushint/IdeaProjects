package com.lotushint.Book.test;

import com.lotushint.Book.dao.BookDao;
import com.lotushint.Book.dao.impl.BookDaoImpl;
import com.lotushint.Book.pojo.Book;

import java.math.BigDecimal;

/**
 * @author hefan
 * @package com.lotushint.Book.test
 * @date 2021/11/19 20:44
 * @description
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @org.junit.Test
    public void addBook() {
        bookDao.addBook(new Book(null,"国歌为什么这么好听！","191125",new BigDecimal(9999),1100000,0,null));
    }

    @org.junit.Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @org.junit.Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"歌都好听！","国歌",new BigDecimal(9999),1100000,0,null));
    }

    @org.junit.Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @org.junit.Test
    public void queryBooks(){
        for (Book queryBook: bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
}