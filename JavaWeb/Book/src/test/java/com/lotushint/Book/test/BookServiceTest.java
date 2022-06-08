package com.lotushint.Book.test;

import com.lotushint.Book.pojo.Book;
import com.lotushint.Book.service.BookService;
import com.lotushint.Book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"lotushint you","1125",new BigDecimal(100000),1000000000,0,null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBookById() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
    }
}