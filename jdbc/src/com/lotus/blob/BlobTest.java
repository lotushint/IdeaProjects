package com.lotus.blob;

import com.lotus.bean.Customer;
import com.lotus.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * com.lotus.blob
 * hefan
 * <p>
 * 2021/8/7 8:38
 * 测试使用PreparedStatement操作Blob类型的数据
 */
public class BlobTest {
    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"张宇豪");
        preparedStatement.setObject(2,"zhang@qq.com");
        preparedStatement.setObject(3,"1999-08-09");
        FileInputStream inputStream = new FileInputStream(new File("girl.jpg"));
        preparedStatement.setBlob(4,inputStream);
        preparedStatement.execute();
        inputStream.close();
        JDBCUtils.closeResource(connection,preparedStatement);
    }
    //查询数据表customers中Blob类型的字段
    @Test
    public void testQuery() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream =null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,29);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                //方式一：
    //            int id = resultSet.getInt(1);
    //            String name = resultSet.getString(2);
    //            String email  = resultSet.getString(3);
    //            Date date = resultSet.getDate(4);
                //方式二：比方式一好，以列别名查找，而不是以列索引
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");

                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = resultSet.getBlob("photo");
                inputStream = photo.getBinaryStream();
                fileOutputStream = new FileOutputStream("zhangyuhao.jpg");
                byte[] buffer = new byte[1025];
                int len;
                while ((len = inputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer,0,len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();

                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

    }
}
