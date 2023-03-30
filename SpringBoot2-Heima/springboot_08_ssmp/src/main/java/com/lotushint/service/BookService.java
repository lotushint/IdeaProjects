package com.lotushint.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lotushint.domain.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/20 21:23
 * @package com.lotushint.service
 * @description
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}
