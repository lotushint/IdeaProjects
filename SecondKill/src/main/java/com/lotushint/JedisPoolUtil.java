package com.lotushint;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/18 13:18
 * @package com.lotushint
 * @description
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil() {
    }

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(200);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    poolConfig.setBlockWhenExhausted(true);
                    // ping  PONG
                    poolConfig.setTestOnBorrow(true);

                    jedisPool = new JedisPool(poolConfig, "192.168.138.129", 6379, 60000);
                }
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedis) {
            jedisPool.returnResource(jedis);
        }
    }

}