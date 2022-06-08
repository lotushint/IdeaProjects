package com.lotushint.Book.dao;

import com.lotushint.Book.pojo.Book;

import java.util.List;

/**
 * @author hefan
 * @package com.lotushint.Book.dao
 * @date 2021/11/16 16:06
 * @description
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
