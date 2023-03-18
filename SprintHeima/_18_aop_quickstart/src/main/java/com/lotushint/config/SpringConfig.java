package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lotushint")
//开启注解开发 AOP 功能
@EnableAspectJAutoProxy
public class SpringConfig {
}
