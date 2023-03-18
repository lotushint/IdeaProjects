package com.lotushint.factory;

import com.lotushint.dao.InstanceDao;
import com.lotushint.dao.impl.InstanceDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 17:59
 * @package com.lotushint.factory
 * @description
 */
public class InstanceFactoryBean implements FactoryBean {
    @Override
    public InstanceDao getObject() throws Exception {
        return new InstanceDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return InstanceDao.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
