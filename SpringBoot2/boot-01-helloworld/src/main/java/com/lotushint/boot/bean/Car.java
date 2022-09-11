package com.lotushint.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@ToString
@Data
//@Component //只有在容器中的组件，才能拥有 springboot 提供的配置绑定功能，除了加上 @Component 注解还可以在配置类中加 @EnableConfigurationProperties(Car.class)
@ConfigurationProperties(prefix = "mycar") //配置绑定配置文件中的属性
public class Car {

    private String brand;
    private Integer price;

}
