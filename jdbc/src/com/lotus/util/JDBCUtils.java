package com.lotus.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * com.lotus.util
 * hefan
 * 2021/8/4 19:24
 * 操作数据库的工具类
 */
public class JDBCUtils {
    /**
     * @description 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //1.读取配置文件中的4个基本信息
            // InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     *
     * @description 关闭连接和Statement的操作
     * @param connection
     * @param preparedStatement
     */
    public static void closeResource(Connection connection, PreparedStatement preparedStatement){
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description关闭资源的操作
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
