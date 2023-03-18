package com.lotushint;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lotushint
 * @version 1.0
 * @date ${DATE} ${TIME}
 * @package com.lotushint
 * @description
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource druidDataSource = ctx.getBean(DataSource.class);
        Connection connection = druidDataSource.getConnection();
        System.out.println(druidDataSource);
    }
}