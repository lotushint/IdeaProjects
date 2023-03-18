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
    private int connectNum;
    private String databaseName;

    public BookDaoImpl(int connectNum, String databaseName) {
        this.connectNum = connectNum;
        this.databaseName = databaseName;
    }

    public void save() {
        System.out.println("book save " + databaseName + " " + connectNum);
    }
}
