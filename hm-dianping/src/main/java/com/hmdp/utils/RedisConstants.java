package com.hmdp.utils;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/17 16:23
 * @package com.hmdp.utils
 * @description
 */
public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "login:code:";
    public static final String LOGIN_TOKEN_KEY = "login:token:";
    public static final Long LOGIN_CODE_TTL = 2L;
    public static final Long LOGIN_TOKEN_TTL = 30L;
}
