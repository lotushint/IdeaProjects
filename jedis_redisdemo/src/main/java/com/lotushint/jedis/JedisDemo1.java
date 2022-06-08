package com.lotushint.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/6 19:36
 * @package com.lotushint.jedis
 * @description
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        //创建redis对象
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        String value = jedis.ping();
        System.out.println(value);
    }

    /**
     * 操作key string
     */
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("192.168.138.129", 6379);

        /*
        设置一个key-value
         */
        jedis.set("name", "luck");

        String name = jedis.get("name");
        System.out.println(name);

        /*
        设置多个key-value
         */
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    /**
     * 操作list
     */
    @Test
    public void demo2() {
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        jedis.lpush("key1", "lucy", "mary", "jack");
        List<String> values = jedis.lrange("key1", 0, -1);
        System.out.println(values);
    }

    /**
     * 操作set
     */
    @Test
    public void demo3() {
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        jedis.sadd("names","lucy","jack","jack");
        Set<String> names = jedis.smembers("names");
        System.out.println(names);
    }

    /**
     * 操作hash
     */
    @Test
    public void demo4() {
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        jedis.hset("users","age","20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
    }

    /**
     * 操作zset
     */
    @Test
    public void demo5() {
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        jedis.zadd("china",100,"shanghai");
        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
    }
}
