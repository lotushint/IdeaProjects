package com.lotushint;

import com.lotushint.dao.InstanceDao;
import com.lotushint.dao.StaticDao;
import com.lotushint.factory.InstanceFactory;
import com.lotushint.factory.InstanceFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lotushint
 * @version 1.0
 * @date ${DATE} ${TIME}
 * @package com.lotushint
 * @description
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 静态工厂
        StaticDao staticDao = (StaticDao) ctx.getBean("staticDao");
        staticDao.staticFactory();

        // 实例工厂
//        InstanceFactory instanceFactory = new InstanceFactory();
//        InstanceDao instanceDao = instanceFactory.getInstanceDao();
//        instanceDao.instanceFactory();
        //实例工厂改进
        InstanceDao instanceDao = (InstanceDao) ctx.getBean("instanceDao");
        instanceDao.instanceFactory();
    }
}