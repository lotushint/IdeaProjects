package com.itheima;

import com.lotushint.Springboot06MybatisPlusApplication;
import com.lotushint.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot06MybatisPlusApplication.class)
class Springboot06MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

}
