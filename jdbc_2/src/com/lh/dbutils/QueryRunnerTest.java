package com.lh.dbutils;

import com.hint.bean.Customer;
import com.hintlotus.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author hefan
 * @package com.lh.dbutils
 * @date 2021/8/12 9:34
 * @description commons-dbutils 是Apache组织提供的一个开源JDBC工具类库，封装了针对于数据库的增删改查操作
 */
public class QueryRunnerTest {
    //测试查询
    @Test
    public void testInsert() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = queryRunner.update(connection, sql, "蔡徐坤", "caixukun@11545.com", "1999-12-23");
            System.out.println("添加了" + insertCount + "条记录");
            System.out.println("QueryRunnerTest.testInsert");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    //测试查询
    /*
     * BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
     */
    @Test
    public void testQuery1() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            BeanHandler<Customer> beanHandler = new BeanHandler<>(Customer.class);
            Customer customer = queryRunner.query(connection, sql, beanHandler, 19);
            System.out.println(customer);
            System.out.println("QueryRunnerTest.testQuery1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    /*
     * BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
     */
    @Test
    public void testQuery2() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> beanHandler = new BeanListHandler<>(Customer.class);
            List<Customer> customer = queryRunner.query(connection, sql, beanHandler, 19);
            customer.forEach(System.out::println);
            System.out.println("QueryRunnerTest.testQuery2");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    /*
     * MapHander:是ResultSetHandler接口的实现类，对应表中的一条记录。
     * 将字段及相应字段的值作为map中的key和value
     */
    @Test
    public void testQuery3() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> customer = queryRunner.query(connection, sql, mapHandler, 19);
            System.out.println(customer);
            System.out.println("QueryRunnerTest.testQuery3");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    /*
     * MapListHander:是ResultSetHandler接口的实现类，对应表中的多条记录。
     * 将字段及相应字段的值作为map中的key和value。将这些map添加到List中
     */
    @Test
    public void testQuery4() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler mapHandler = new MapListHandler();
            List<Map<String, Object>> customer = queryRunner.query(connection, sql, mapHandler, 19);
            //System.out.println(customer);//输出列表[]
            customer.forEach(System.out::println);
            System.out.println("QueryRunnerTest.testQuery4");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    /*
     * ScalarHandler:用于查询特殊值
     */
    @Test
    public void testQuery5() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();
            Long count  = (Long) queryRunner.query(connection, sql, scalarHandler);
            System.out.println(count);//输出列表[]
            System.out.println("QueryRunnerTest.testQuery5");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    @Test
    public void testQuery6() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            ScalarHandler scalarHandler = new ScalarHandler();
            String sql = "select max(birth) from customers";
            Date date = (Date) queryRunner.query(connection, sql, scalarHandler);
            System.out.println(date);
            System.out.println("QueryRunnerTest.testQuery6");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
    @Test
    public void testQuery7() {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            connection = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            ResultSetHandler<Customer> resultSetHandler = new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet resultSet) throws SQLException {
                    //					System.out.println("handle");
//					return null;

//					return new Customer(12, "成龙", "Jacky@126.com", new Date(234324234324L));

                    if(resultSet.next()){
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        Date birth = resultSet.getDate("birth");
                        Customer customer = new Customer(id, name, email, birth);
                        return customer;
                    }
                    return null;
                }
            };
            Customer customer = queryRunner.query(connection,sql,resultSetHandler,19);
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }
}
