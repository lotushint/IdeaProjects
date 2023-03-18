package com.lotushint.factory;

import com.lotushint.dao.StaticDao;
import com.lotushint.dao.impl.StaticDaoImpl;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 17:37
 * @package com.lotushint.factory
 * @description 静态工厂
 */
public class StaticFactory {
    public static StaticDao getStaticDao() {
        return new StaticDaoImpl();
    }
}
