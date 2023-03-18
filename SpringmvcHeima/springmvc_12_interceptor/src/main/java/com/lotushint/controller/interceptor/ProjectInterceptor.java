package com.lotushint.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/13 22:01
 * @package com.itheima.controller.interceptor
 * @description
 */
@Component//服务于springmvc,要受springmvc扫描
//定义拦截器类，实现 HandlerInterceptor 接口
//注意当前类必须受 Spring容 器控制
public class ProjectInterceptor implements HandlerInterceptor {
    //原始方法调用前执行的内容
    //preHandle可以用来做校验，根据校验是否成功来判断是否执行后面的操作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contentType = request.getHeader("Content-Type");
        HandlerMethod hm = (HandlerMethod)handler;
        System.out.println(hm.getMethod());
        System.out.println("preHandle..."+contentType);
        return true;//一定要是 true,如果是false,则原始操作后的操作都不会执行
    }

    //原始方法调用后执行的内容
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    //原始方法调用完成后执行的内容（在postHandle之后）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
