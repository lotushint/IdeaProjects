package com.lotus.transaction;

import com.lotus.util.JDBCUtils;
import org.junit.Test;

import java.lang.annotation.Target;
import java.sql.Connection;

/**
 * com.lotus.transaction
 * hefan
 * <p>
 * 2021/8/7 14:16
 */
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
