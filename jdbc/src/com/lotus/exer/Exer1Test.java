package com.lotus.exer;

import com.lotus.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * com.lotus.exer
 * hefan
 * <p>
 * 2021/8/6 20:52
 * 课后练习1
 */
public class Exer1Test {
    @Test
    public void testUpdate(){
        String sql = "INSERT INTO customers(NAME,email,birth) VALUE(?,?,?)";
        update(sql,"何帆","2870999158@qq.com","2000-4-17");
    }
    public void update(String sql,Object...args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length;i++){
                preparedStatement.setObject(i + 1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }
}
