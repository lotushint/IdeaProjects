package com.lotushint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/4 17:29
 * @package com.lotushint.config
 * @description
 */
@Configuration
@ComponentScan("com.lotushint")
@PropertySource("jdbc.properties")
public class SpringConfig {
}
