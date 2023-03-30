package com.lotushint.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lotushint.domain.Book;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/20 21:46
 * @package com.lotushint.service
 * @description
 */
@Service
public interface IBookService extends IService<Book> {
    public IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
