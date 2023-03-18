package com.lotushint.factory;

import com.lotushint.dao.InstanceDao;
import com.lotushint.dao.StaticDao;
import com.lotushint.dao.impl.InstanceDaoImpl;
import com.lotushint.dao.impl.StaticDaoImpl;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 17:37
 * @package com.lotushint.factory
 * @description 实例工厂
 */
public class InstanceFactory {
    public InstanceDao getInstanceDao() {
        return new InstanceDaoImpl();
    }
}
