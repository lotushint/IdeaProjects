package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lotushint")
@EnableAspectJAutoProxy
public class SpringConfig {
}
