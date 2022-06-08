package com.lotus.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hefan
 * @package com.lotus.spring5.dao
 * @date 2021/10/2 13:32
 * @description
 */

public interface UserDao {
    /**
     * lucy 转账 100 给 mary
     * 少钱
     */
    void reduceMoney();

    /**
     * 多钱
     */
    void addMoney();
}
