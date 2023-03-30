package com.itheima.util.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/27 19:09
 * @package com.itheima.util.jedis
 * @description
 */
public class JedisConnectionFactory {
    private final static JedisPool jedispool;

    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(8);
        poolConfig.setMaxWaitMillis(1000);
        jedispool = new JedisPool(poolConfig, "192.168.245.129", 6379, 1000, "123456");
    }

    public static Jedis getJedis() {
        return jedispool.getResource();
    }
}
