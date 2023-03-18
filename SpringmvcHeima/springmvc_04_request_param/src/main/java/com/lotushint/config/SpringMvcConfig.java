package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/10 21:56
 * @package com.lotushint.config
 * @description
 */
@Configuration
@ComponentScan("com.lotushint")
@EnableWebMvc
public class SpringMvcConfig {
}
