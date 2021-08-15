package com.hintlotus.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @package com.hintlotus.connection
 * @author hefan
 * @date 2021/8/11 16:33
 * @description
 */
public class DBCPTest {
    /**
     * 测试DBCP的数据库连接池技术
     */
    @Test
    public void testGetConnection() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource dataSource = new BasicDataSource();
        //设置基本信息
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //还可以设置其他涉及到数据库管理的相关属性
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(10);
        //...

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println("DBCPTest.testGetConnection");
    }
    //方式二：
    @Test
    public void testGetConnection1() throws Exception {
        Properties properties = new Properties();
        //方式一：
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式二：
        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
        properties.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
