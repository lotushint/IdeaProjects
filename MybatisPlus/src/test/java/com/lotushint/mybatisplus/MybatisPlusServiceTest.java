package com.lotushint.mybatisplus;

import com.lotushint.mybatisplus.pojo.User;
import com.lotushint.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 10:14
 * @package com.lotushint.mybatisplus
 * @description
 */
@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    /**
     * 批量添加
     */
    @Test
    public void testSaveBatch() {
        // SQL 长度有限制，海量数据插入单条 SQL 无法实行，
        // 因此 MP 将批量插入放在了通用 Service 中实现，而不是通用 Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("lotus" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        //SQL:INSERT INTO t_user ( username, age ) VALUES ( ?, ? )
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }
}
