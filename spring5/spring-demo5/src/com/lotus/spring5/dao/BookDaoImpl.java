package com.lotus.spring5.dao;

import com.lotus.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author hefan
 * @package com.lotus.spring5.dao
 * @date 2021/8/27 13:10
 * @description
 */
@Repository
public class BookDaoImpl implements BookDao{

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //1 创建sql语句
        String sql = "INSERT INTO user_table VALUES(?,?,?)";
        //2 调用方法实现
        Object[] args = {book.getUserId(),book.getUserName(),book.getUsStatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    //修改
    @Override
    public void updateBook(Book book) {
        String sql = "update user_table set user=?,password=? where balance=1445";
        Object[] args = {book.getUserId(),book.getUserName()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    //删除
    @Override
    public void delete(String user) {
        String sql = "delete from user_table where user=?";
        int update = jdbcTemplate.update(sql,user);
        System.out.println(update);
    }

    //查询表记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from user_table";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //查询返回对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from user where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from user";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "INSERT INTO user VALUES(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update user set user_name=?,us_status=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from user where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
