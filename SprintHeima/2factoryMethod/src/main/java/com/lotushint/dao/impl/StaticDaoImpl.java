package com.lotushint.dao.impl;

import com.lotushint.dao.StaticDao;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 17:37
 * @package com.lotushint.dao.impl
 * @description
 */
public class StaticDaoImpl implements StaticDao {
    @Override
    public void staticFactory() {
        System.out.println("staticFactory");
    }
}
