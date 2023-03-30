package com.itheima.test;

import com.itheima.util.jedis.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/27 18:16
 * @package com.itheima.test
 * @description
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setup() {
        // 1.建立连接
//        jedis = new Jedis("192.168.245.129", 6379);
        jedis = JedisConnectionFactory.getJedis();
        // 2.设置密码
        jedis.auth("123456");
        // 3.选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        // 存入数据
        String result = jedis.set("name", "lotushint2");
        System.out.println("result = " + result);

        // 获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    void testHash() {
        // 插入 hash 数据
        jedis.hset("heima:user:3", "name", "hint");
        jedis.hset("heima:user:3", "sex", "24");

        //获取 hash 数据
        Map<String, String> map = jedis.hgetAll("heima:user:3");
        System.out.println(map);
    }

    @AfterEach
    void close() {
        //释放资源
        if (jedis != null) {
            jedis.close();
        }
    }
}
