package com.lotushint.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lotushint.dao.BookDao;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/7 18:08
 * @package com.lotushint.config
 * @description
 */
//@Configuration //注意要在 SpringConfig.class 加 @ComponentScan 第一种1
public class DruidConfig {
    @Bean
    public DataSource dataSource(BookDao bookDao) {
        System.out.println(bookDao);// bookDao会自动注入
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.245.129:3306/coronavirus");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
}
