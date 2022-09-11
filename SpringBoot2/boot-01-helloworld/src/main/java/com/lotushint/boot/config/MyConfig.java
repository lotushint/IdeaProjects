package com.lotushint.boot.config;


import ch.qos.logback.core.util.OptionHelper;
import com.lotushint.boot.bean.Car;
import com.lotushint.boot.bean.Pet;
import com.lotushint.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.Optional;


/**
 * 1、配置类里面使用 @Bean 标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理 bean 的方法
 * Full(proxyBeanMethods = true)  【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false) 【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用 Full 模式默认。其他默认是否 Lite 模式
 * <p>
 * 4、@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 * <p>
 * <p>
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 */

@Import({User.class, OptionHelper.class})
@Configuration(proxyBeanMethods = false) //告诉SpringBoot这是一个配置类 == 配置文件
//@ConditionalOnBean(name = "tom") //容器中有 tom 组件才装配组件
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)//1、开启Car配置绑定功能  2、把这个Car这个组件自动注册到容器中
public class MyConfig {


    /**
     * Full:外部无论对配置类中的 这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     *
     * @return
     */
//    @ConditionalOnBean(name = "tom")
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01() {
        User zhangsan = new User("zhangsan", 18);
        //user 组件依赖了 Pet 组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
//        return new User("zhangsan", 18);
    }

    @Bean("tom22")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }

//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }
}
