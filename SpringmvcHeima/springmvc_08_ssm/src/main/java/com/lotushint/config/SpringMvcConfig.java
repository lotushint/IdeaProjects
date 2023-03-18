package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/11 20:42
 * @package com.lotushint.config
 * @description
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.lotushint.controller")
public class SpringMvcConfig {
}
