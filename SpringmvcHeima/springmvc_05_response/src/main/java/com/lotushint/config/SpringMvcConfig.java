package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/11 11:38
 * @package com.lotushint.config
 * @description
 */
@Configuration
@ComponentScan("com.lotushint.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
