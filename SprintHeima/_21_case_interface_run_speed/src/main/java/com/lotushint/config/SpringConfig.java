package com.lotushint.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.lotushint")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}
