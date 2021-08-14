package com.lotus.preparedstatement;

import com.lotus.bean.Order;
import com.lotus.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * com.lotus.preparedstatement
 * hefan
 * <p>
 * 2021/8/6 9:22
 * 针对于Order表的通用的查询操作
 */
public class OrderForQuery {
    /**
     * 针对于表的字段名与类的属性名不相同的情况下   Order类中的属性与sql语句中的字段名不相同
     * 1.必须声明sql时，使用类的属性名来命名字段的别名
     * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名。
     *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名——————————————————————————————
     */
    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = OrderForQuery(sql,1);
        System.out.println(order);
    }
    /**
     * 针对于order表的查询操作
     * @return
     */
    public Order OrderForQuery(String sql,Object ...args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0;i < args.length;i++){
                preparedStatement.setObject(i + 1,args[i]);
            }

            //执行，获取结果集
            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //获取列数
            int columnCount = resultSetMetaData.getColumnCount();
            if (resultSet.next()){
                Order order = new Order();
                for (int i = 0;i < columnCount;i++){
                    //获取每个列的列值：通过ResultSet
                    Object columnValue = resultSet.getObject(i + 1);
                    //通过ResultSetMetaData
                        //获取每个列的列名：getColumnName() ---不推荐使用
                        //获取每个列的别名：getColumnLabel()
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    //通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
                    // columnName为Order类中的与表中列名不一致会导致错误，解决：在sql语句中为列起别名！！！！！！！！
                    Field field = Order.class.getDeclaredField(columnLabel);

                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }
    @Test
    public void testQuery1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select order_id,order_name,order_date from `order` where order_id = ?";//此处单引号,用波浪键
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);

                Order order = new Order(id,name,date);
                System.out.print(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
    }
}
