package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

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
