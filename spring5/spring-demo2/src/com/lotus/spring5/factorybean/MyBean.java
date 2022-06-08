package com.lotus.spring5.factorybean;

import com.lotus.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author hefan
 * @package com.lotus.spring5.factorybean
 * @date 2021/8/17 17:16
 * @description
 */
public class MyBean implements FactoryBean<Course> {
    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
