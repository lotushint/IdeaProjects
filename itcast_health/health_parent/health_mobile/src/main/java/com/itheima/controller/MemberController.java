package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.itheima.constant.MessageConstant;
import com.itheima.constant.RedisMessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Member;
import com.itheima.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/2 10:44
 * @package com.itheima.controller
 * @description 处理会员相关操作
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private JedisPool jedisPool;

    @Reference
    private MemberService memberSevice;

    /**
     * 手机号快速登录
     *
     * @param map
     */
    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestBody Map map) {
        String telephone = (String) map.get("telephone");
        String validateCode = (String) map.get("validateCode");
        // 从 Redis 中获取保存的验证码
        String validateCodeInRedis = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_LOGIN);
        if (validateCode != null && validateCodeInRedis != null && validateCode.equals(validateCodeInRedis)) {
            // 验证码输入正确
            // 判断当前用户是否为会员（查询会员表来决定）
            Member member = memberSevice.findByTelephone(telephone);
            if (member == null) {
                // 不是会员，自动完成注册（自动将当前用户信息保存到会员表）
                member.setRegTime(new Date());
                member.setPhoneNumber(telephone);
                memberSevice.add(member);
            }
            // 向客户端浏览器写入 Cookie ，内容为手机号
            Cookie cookie = new Cookie("login_member_telephone", telephone);
            cookie.setPath("/");//路径
            cookie.setMaxAge(60 * 60 + 24 * 30);//有效期 30天
            response.addCookie(cookie);
            //保存会员信息到 Redis中
            String json = JSON.toJSON(member).toString();
            jedisPool.getResource().setex(telephone, 60 * 30, json);
            return new Result(true, MessageConstant.LOGIN_SUCCESS);
        } else {
            // 验证码输入错误
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }
}
