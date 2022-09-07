package com.lotushint.mybatisplus;

import com.lotushint.mybatisplus.enums.SexEnum;
import com.lotushint.mybatisplus.mapper.UserMapper;
import com.lotushint.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 19:23
 * @package com.lotushint.mybatisplus
 * @description
 */
@SpringBootTest
public class MybatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
    }
}
