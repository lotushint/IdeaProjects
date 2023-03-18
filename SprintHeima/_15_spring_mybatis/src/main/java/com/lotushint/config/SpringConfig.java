package com.lotushint.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.lotushint.config.DruidConfig;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/7 19:36
 * @package com.lotushint
 * @description
 */
@Configuration
@ComponentScan("com.lotushint")
@Import({DruidConfig.class, MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

}
