package com.lotushint.mybatisplus;

import com.lotushint.mybatisplus.mapper.UserMapper;
import com.lotushint.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/6 20:08
 * @package com.lotushint.mybatisplus
 * @description
 */
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有数据
     */
    @Test
    public void testSelectList() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
//        list.forEach(user -> System.out.println(user));
    }

    /**
     * 插入一条数据
     */
    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "zhangsan@lotushint.com");
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);

        System.out.println("受影响行数：" + result);
        //1567128589088862210
        System.out.println("id自动获取：" + user.getId());
        //System.out.println("id自动获取：" + user.getUid());
    }

    /**
     * 通过id删除用户信息<br>
     * DELETE FROM user WHERE id=?
     */
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1567128589088862210L);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 根据map集合中所设置的条件删除记录<br>
     * DELETE FROM user WHERE name = ? AND age = ?
     */
    @Test
    public void testDeleteByMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "张三");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 通过多个id批量删除<br>
     * DELETE FROM user WHERE id IN ( ? , ? , ? )
     */
    @Test
    public void testDeleteBatchIds() {
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 修改一条数据<br>
     * UPDATE user SET name=?, age=? WHERE id=?
     */
    @Test
    public void testUpdateById() {
        User user = new User(4L, "admin", 22, null);
        int result = userMapper.updateById(user);
        System.out.println("受影响行数：" + result);
    }

    /**
     * 根据id查询用户信息<br>
     * SELECT id,name,age,email FROM user WHERE id=?
     */
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    /**
     * 根据多个id查询多个用户信息<br>
     * SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
     */
    @Test
    public void testSelectBatchIds() {
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }

    /**
     * 通过 map 条件查询用户信息<br>
     * SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
     */
    @Test
    public void testSelectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 20);
        map.put("name", "jack");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    /**
     * 根据 id 查询用户信息为 map 集合
     */
    @Test
    public void testSelectMapById() {
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

}