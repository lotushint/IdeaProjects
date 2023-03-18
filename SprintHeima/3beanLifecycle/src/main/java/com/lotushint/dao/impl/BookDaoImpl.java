package com.lotushint.dao.impl;

import com.lotushint.dao.BookDao;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.dao.impl
 * @description
 */
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("save");
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
