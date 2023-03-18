package com.lotushint.dao.impl;

import com.lotushint.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/3 16:31
 * @package com.lotushint.dao.impl
 * @description
 */
@Repository
public class BookDaoImpl implements BookDao {

    public void save() {
        System.out.println("book save ");
    }
}
