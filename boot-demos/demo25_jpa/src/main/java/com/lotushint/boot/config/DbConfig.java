package com.lotushint.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 11:24
 * @package com.lotushint.boot.config
 * @description 第二种配置数据源的方式
 */
@Data
@ComponentScan
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DbConfig {
    String url;
    String username;
    String password;

    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
