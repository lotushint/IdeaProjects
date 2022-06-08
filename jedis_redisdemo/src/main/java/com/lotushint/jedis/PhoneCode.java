package com.lotushint.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/10 15:16
 * @package com.lotushint.jedis
 * @description
 */
public class PhoneCode {
    public static void main(String[] args) {
        //模拟验证码发送
        verifyCode("18446104569");

        getRedisCode("18446104569","741439");
    }

    /**
     * 验证码校验
     * @param phone
     * @param code
     */
    public static void getRedisCode(String phone, String code) {
        //从redis中获取验证码
        Jedis jedis = new Jedis("192.168.138.129", 6379);
        //验证码 key
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        //判断
        if (redisCode.equals(code)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        jedis.close();
    }

    /**
     * 每个手机每天只能发送三次，验证码放到redis中，设置过期时间
     *
     * @param phone
     */
    public static void verifyCode(String phone) {
        Jedis jedis = new Jedis("192.168.138.129", 6379);

        //拼接 key
        //手机发送次数 key
        String countKey = "VerifyCode" + phone + ":count";
        //验证码 key
        String codeKey = "VerifyCode" + phone + ":code";
        //每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null) {
            //没有发送次数，第一次发送
            //设置发送次数是 1
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            //发送次数 +1
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天发送次数已经超过三次");
            jedis.close();
            //要加，否则三次之后还会发送验证码到 redis
            return;
        }

        //发送的验证码放到redis里面
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    /**
     * 生成6位验证码
     *
     * @return
     */
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }
}
