package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.lotushint.controller", "com.lotushint.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
