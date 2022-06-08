package com.lotushint.mvc.controller;

import com.lotushint.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    /**
     * 测试请求体注解: @RequestBody可以获取请求体，需要在控制器方法设置一个形参，
     * 使用 @RequestBody进行标识，当前请求的请求体就会为当前注解所标识的形参赋值
     *
     * @param requestBody
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("RequestBody:" + requestBody);
        return "success";
    }

    /**
     * 测试请求实体类型：
     *
     * @param requestEntity
     * @return
     */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("requestHeader:" + requestEntity.getHeaders());
        System.out.println("requestBody:" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().print("hello,response");
    }


    /*
    下面三个方法为测试 @ResponseBody
     */

    /**
     * 去掉 @ResponseBody注解，return后面的字符串作为返回到浏览器的数据被解析
     * 加上 @ResponseBody注解，return后面的字符串作为视图名称被解析
     * <p>
     * 当个我们 不 是要将java对象响应到浏览器的时候 不 要加jackson的jar包(本方法)
     *
     * @return
     */
    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody() {
        return "成功";
    }

    /**
     * SpringMVC处理json
     * 当个我们要将java对象响应到浏览器的时候要加jackson的jar包(本方法)
     *
     * @return
     */
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "admin", "123456", 23, "男");
    }

    /**
     * SpringMVC处理ajax
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + "," + password);
        return "hello,axios";
    }
}
