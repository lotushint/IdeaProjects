package com.lotushint.boot.config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/15 13:42
 * @package com.lotushint.boot.config
 * @description
 */
//@Configuration
public class DefaultMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        //setUseSuffixPatternMatch:设置是否遵循后缀匹配模式，如“/user”是否匹配/user.*，为true时就匹配;
        configurer.setUseSuffixPatternMatch(true)
                //setUseTrailingSlashMatch,设置是否自动后缀留级匹配模式，如“/user”是否匹配“/user/”，为true是即匹配
                .setUseTrailingSlashMatch(true);
    }

}
