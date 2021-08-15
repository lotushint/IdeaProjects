package com.hintlotus.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * com.hintlotus.connection
 * hefan
 * <p>
 * 2021/8/11 15:42
 */
public class C3P0Test {
    //方式一：
    @Test
    public void testGetConnection() throws Exception {
        //获取c3p0连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        //通过设置相关的参数，对数据库连接池进行管理
        //设置初始数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);

        //销毁c3p0数据库连接池，一般不做这个操作
//        DataSources.destroy(cpds);
    }
    //方式二：使用配置文件
    @Test
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hello3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
