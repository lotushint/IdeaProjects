package com.lotushint.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/7 17:50
 * @package com.lotushint.config
 * @description
 */
@Configuration
@ComponentScan("com.lotushint") //第一种2
@Import({DruidConfig.class}) //第二种   推荐
public class SpringConfig {

}
