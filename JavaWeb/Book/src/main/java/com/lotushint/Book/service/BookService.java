package com.lotushint.Book.service;

import com.lotushint.Book.pojo.Book;

import java.util.List;

/**
 * @author hefan
 * @package com.lotushint.Book.service
 * @date 2021/11/25 11:43
 * @description
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBookById(Book book);

    public void queryBookById(Integer id);

    public List<Book> queryBooks();
}
