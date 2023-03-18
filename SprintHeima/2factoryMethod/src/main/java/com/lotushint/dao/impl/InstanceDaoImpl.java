package com.lotushint.dao.impl;

import com.lotushint.dao.InstanceDao;
import com.lotushint.dao.StaticDao;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 17:37
 * @package com.lotushint.dao.impl
 * @description
 */
public class InstanceDaoImpl implements InstanceDao {
    @Override
    public void instanceFactory() {
        System.out.println("instanceFactory");
    }
}
