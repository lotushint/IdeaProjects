package com.hint.dao;

import com.hint.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.BitSet;
import java.util.List;

/**
 * com.lotus.dao
 * hefan
 * <p>
 * 2021/8/9 8:36
 */
public class CustomerDAOImpl extends BaseDao implements CustomerDAO {

    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(conn,Customer.class, sql,id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = getForList(connection,Customer.class,sql);
        return list;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        return getValue(connection,sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(birth) from customers";
        return getValue(connection,sql);
    }
}
