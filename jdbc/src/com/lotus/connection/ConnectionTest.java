package com.lotus.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testConnection() throws SQLException {
        //方式一
        // 获取Driver实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        // url:http://localhost:8080/gmall/keyboard.jpg
        // jdbc:mysql:协议
        // localhost:ip地址
        // 3306：默认mysql的端口号
        // test:test数据库
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
    }

    @Test
    public void Connection2() throws Exception {
        // 方式二：对方式一的迭代:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
        // 1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        // 3.提供连接需要的用户名和密码
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        // 4.获取连接
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
    }

    @Test
    public void Connection3() throws Exception {
        //方法三：使用DriverManager替换Driver
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        //clazz.newInstance()过时
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/testjdbc?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user = "root";
        String password = "123456";
        //注册驱动
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }

    @Test
    public void testConnection4() throws Exception {
        // 方式四：可以只是加载驱动，不用注册驱动
        // 1.提供三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        String user = "root";
        String password = "123456";

        // 2.加载Driver（其实这个也可以省，但是不要省）
        Class.forName("com.mysql.cj.jdbc.Driver");
        //相较于方式三，可以省略如下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(driver);
        //为什么可以省略上述操作呢？
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */

        // 3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
    //方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /**
     * 此种方式的好处？
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void getConnection5() throws Exception{

        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

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
        System.out.println(connection);


    }
}
