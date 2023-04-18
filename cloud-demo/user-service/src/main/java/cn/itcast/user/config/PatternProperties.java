package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/17 13:10
 * @package cn.itcast.user.config
 * @description // TODO 配置热更新 第二种方式 1
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;
}
