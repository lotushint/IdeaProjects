package com.lotushint.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lotushint.mybatisplus.mapper.UserMapper;
import com.lotushint.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 14:19
 * @package com.lotushint.mybatisplus
 * @description
 */
@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        //查询用户名包含 a，年龄在 20 到 30 之间，并且邮箱不为 null 的用户信息
        // SELECT id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (username LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        // SELECT id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //删除email为空的用户
        // DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        //条件构造器也可以构建删除语句的条件
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test04() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        // UPDATE t_user SET age=?, email=? WHERE (user_name LIKE ? AND age > ? OR email IS NULL)}
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .gt("age", "20")
                .or()
                .isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@lotus.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND (age > ? OR email IS NULL))}
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //lambda表达式内的逻辑优先运算
        queryWrapper.like("user_name", "a")
                .and(i -> i.gt("age", 19)
                        .or()
                        .isNull("email"));
        User user = new User();
        user.setAge(99);
        user.setEmail("user@hint.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test06() {
        //查询用户信息的 user_name 和 age 字段
        // SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age");
        // selectMaps()返回 Map 集合列表，通常配合 select() 使用，避免 User 对象中没有被查询到的列值 为 null
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07() {
        //查询 id 小于等于 3 的用户信息
        // SELECT id,user_name AS name,age,email,is_deleted FROM t_user WHERE (id IN (select id from t_user where id <= 3))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid <= 3");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08() {
        //将（年龄大于 20 或邮箱为 null）并且用户名中包含有 a 的用户信息修改
        // 组装 set 子句以及修改条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // lambda表达式内的逻辑优先运算
        updateWrapper.set("age", 18)
                .set("email", "user@lotushint.com")
                .like("user_name", "a")
                .and(i -> i.gt("age", 20)
                        .or()
                        .isNull("email"));
        updateWrapper.set("user_name", "小明")
                .set("email", "abc@qq.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:" + result);
        //这里必须要创建User对象，否则无法应用自动填充。如果没有自动填充，可以设置为null
        // UPDATE t_user SET username=?, age=?,email=? WHERE (username LIKE ? AND (age > ? OR email IS NULL))
        // User user = new User();
        // user.setName("张三");
        //int result = userMapper.update(user, updateWrapper);

        // UPDATE t_user SET age=?,email=? WHERE (username LIKE ? AND (age > ? OR email IS NULL))
//        int result = userMapper.update(null, updateWrapper);
//        System.out.println(result);
    }

    @Test
    public void test09() {
        //定义查询条件，有可能为 null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("user_name", "a");
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted='0' AND (age >= ? AND age <= ?)
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 上面 test09 代码太复杂，简化
     */
    @Test
    public void test10() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", "a")
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted='0' AND (age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void test11() {
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted='0' AND (user_name LIKE ? AND age >= ? AND age <= ?)
        //定义查询条件，有可能为 null（用户未输入）
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //避免使用字符串表示字段，防止运行时错误
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * LambdaUpdateWrapper
     */
    @Test
    public void test12() {
        //UPDATE t_user SET age=?,email=? WHERE is_deleted='0' AND (user_name LIKE ? AND (age < ? OR email IS NULL))
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "a")
                .and(i -> i.lt(User::getAge, 24)
                        .or()
                        .isNull(User::getEmail));
        //组装 set 子句
        lambdaUpdateWrapper.set(User::getAge, 18)
                .set(User::getEmail, "user@lotushint.com");
        //lambda 表达式内的逻辑优先运算
        User user = new User();
        int result = userMapper.update(user, lambdaUpdateWrapper);
        System.out.println("受影响的行数：" + result);
    }
}