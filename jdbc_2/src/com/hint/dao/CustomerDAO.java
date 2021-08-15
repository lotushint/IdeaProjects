package com.hint.dao;

import com.hint.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * com.lotus.dao
 * hefan
 * <p>
 * 2021/8/9 8:24
 */
public interface CustomerDAO {
    /**
     * @Description 将customer对象添加到数据库中
     * @param connection
     * @param customer
     */
    void insert(Connection connection, Customer customer);

    /**
     * @Description 针对指定的id，删除表中的一条记录
     * @param connection
     * @param id
     */
    void deleteById(Connection connection,int id);

    /**
     * @Description 针对内存中的customer对象，去修改数据表中指定的记录
     * @param connection
     * @param id
     * @param customer
     */
    void update(Connection connection,Customer customer);

    /**
     * @Description 针对指定的id查询得到对应的Customer对象
     * @param conn
     * @param id
     * @return
     */
    Customer getCustomerById(Connection conn,int id);

    /**
     * @Description 查询表中的所有记录构成的集合
     * @param connection
     * @return
     */
    List<Customer> getAll(Connection connection);

    /**
     * @Description 返回数据表中的数据的条目数
     * @param connection
     * @return
     */
    Long getCount(Connection connection);

    /**
     * @Description 返回数据表中最大的生日
     * @param connection
     * @return
     */
    Date getMaxBirth(Connection connection);
}
