package com.lotus.spring5.dao;

import com.lotus.spring5.entity.Book;

import java.util.List;

/**
 * @author hefan
 * @package com.lotus.spring5.dao
 * @date 2021/8/27 13:11
 * @description
 */
public interface BookDao {
    void add(Book book);

    void updateBook(Book book);

    void delete(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
