package com.itheima.controller;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.constant.MessageConstant;
import com.itheima.constant.RedisMessageConstant;
import com.itheima.entity.Result;
import com.itheima.utils.SMSUtils;
import com.itheima.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/1 11:58
 * @package com.itheima.controller
 * @description 短信验证码
 */
@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 体检预约时发送手机验证码
     *
     * @param telephone
     * @return
     */
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        //随机生成4位验证码
        Integer validateCode = ValidateCodeUtils.generateValidateCode(4);
        //给用户发送验收码
        SMSUtils.sendShortMessage2(SMSUtils.VALIDATE_CODE, telephone, validateCode.toString());

        System.out.println("发送的手机验证码为：" + validateCode);
        //将验证码保存到 Redis（5分钟）
        Jedis jedis = jedisPool.getResource();
        jedis.setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 300, validateCode.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

    /**
     * 手机快速登录时发送手机验证码
     *
     * @param telephone
     * @return
     */
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {
        //随机生成4位验证码
        Integer validateCode = ValidateCodeUtils.generateValidateCode(6);
        //给用户发送验收码
        SMSUtils.sendShortMessage2(SMSUtils.VALIDATE_CODE, telephone, validateCode.toString());

        System.out.println("发送的手机验证码为：" + validateCode);
        //将验证码保存到 Redis（5分钟）
        Jedis jedis = jedisPool.getResource();
        jedis.setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 300, validateCode.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
}
