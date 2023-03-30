package com.lotushint.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lotushint.dao.BookDao;
import com.lotushint.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("计算机");
        book.setName("java从入门到精通");
        book.setDescription("从入门到入土........");
        int i = bookDao.insert(book);
        System.out.println(i);
    }

    @Test
    void testDelete() {
        System.out.println(bookDao.deleteById(13));
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        System.out.println(bookDao.updateById(book));
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 3);
        bookDao.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetByWrapper() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.lambda().like(Book::getName, "Spring");
        System.out.println(bookDao.selectList(qw));
    }

}
