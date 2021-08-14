package com.lotus.preparedstatement;

import com.lotus.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/*
 * 使用PreparedStatement来替换Statement,实现对数据表的增删改操作
 *
 * 增删改；查
 *
 *
 */
public class PreparedStatementUpdateTest {

    @Test
    public void testCommonUpdate(){
//        String sql = "delete from  customers where id = ?";
//        update(sql,2);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql,"BB",2);

    }
    //通用的增删改操作
    public void update(String sql,Object ...args) {//sql中占位符的个数与可变形参的长度相同！
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                preparedStatement.setObject(i + 1, args[i]);//小心参数声明错误！！
            }
            //4.执行
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.资源的关闭
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }
    //修改customers表的一张记录
    @Test
    public void testUpdate() {
        //1.获取数据库的连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";//？为占位符
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            preparedStatement.setObject(1,"莫扎特");
            preparedStatement.setObject(2,18);
            //4.执行
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }

    //向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获得连接
            connection = DriverManager.getConnection(url,user,password);
//        System.out.println(connection);

            //4.预编译sql语句，返回PreparedStatem的实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)";//?:占位符
            preparedStatement = connection.prepareStatement(sql);

            //5.填充占位符
            preparedStatement.setString(1,"哪吒");
            preparedStatement.setString(2,"nezha@gmail.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = simpleDateFormat.parse("1000-01-01");
            preparedStatement.setDate(3,new Date(date.getTime()));

            //6.执行操作
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            //7.资源的关闭
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
