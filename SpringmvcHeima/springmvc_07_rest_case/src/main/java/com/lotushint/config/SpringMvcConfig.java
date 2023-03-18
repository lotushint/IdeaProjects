package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/11 16:58
 * @package com.lotushint.config
 * @description
 */
@Configuration
@ComponentScan({"com.lotushint.controller", "com.lotushint.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
