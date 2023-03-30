package com.lotushint.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lotushint.controller.utils.R;
import com.lotushint.domain.Book;
import com.lotushint.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/21 11:49
 * @package com.lotushint.controller
 * @description
 */
@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        List<Book> list = bookService.list();
        return new R(list != null ? true : false, list);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
/*        R r = new R();
        boolean flag = bookService.save(book);
        r.setFlag(flag);*/
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加成功-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return new R(book == null ? false : true, book);
    }

    /*    @GetMapping("/{currentPage}/{pageSize}")
        public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
            IPage<Book> page = bookService.getPage(currentPage, pageSize);
            //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
            if (currentPage > page.getPages()) {
                page = bookService.getPage((int) page.getPages(), pageSize);
            }
            return new R(page == null ? false : true, page);
        }*/
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
//        System.out.println("参数==>"+book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
