package com.lotushint.boot;

import ch.qos.logback.core.util.OptionHelper;
import com.lotushint.boot.bean.Pet;
import com.lotushint.boot.bean.User;
import com.lotushint.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/9 16:08
 * @package com.lotushint.boot
 * @description 主程序类;主配置类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
//@SpringBootApplication//下面三个注解在 @SpringBootApplication 中
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.lotushint.boot")
public class MainApplication {

    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("======"+beanNamesForType.length);


        //3、从容器中获得组件，默认是单实例的
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType1.length);
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("组件：" + (tom01 == tom02));
//
//        //4、配置类也是单实例，获取到的是代理对象 com.lotushint.boot.config.MyConfig$$EnhancerBySpringCGLIB$$c5810951@4b10789
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//        //如果 @Configuration(proxyBeanMethods = true) 代理对象调用方法
//        //保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//        //用户的宠物就是容器的宠物，把 @Configuration(proxyBeanMethods = true) 改成 false,则不是
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物：" + (user01.getPet() == tom));
//
//        //5、获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("======");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        OptionHelper bean1 = run.getBean(OptionHelper.class);
//        System.out.println(bean1);

        //@Conditional
        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);
        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);

        //原生配置文件引入，测试 @ImportResource("classpath:beans.xml")
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);
        System.out.println("hehe："+hehe);
    }
}