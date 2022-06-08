package com.lotus.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hefan
 * @package com.lotus.spring5.aopanno
 * @date 2021/8/26 11:26
 * @description 增强的类
 */
@Component
@Aspect //生成代理对象
@Order(3)
public class UserProxy {

    /**
     * 相同切入点抽取
     */
    @Pointcut(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    public void pointDemo(){

    }

    /**
     * 前置通知
     * @Before 注解表示作为前置通知
     */
    //@Before(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    @Before(value = "pointDemo()")//其他通知也可以这样
    public void before(){
        System.out.println("before.........");
    }

    /**
     * 后置通知（返回通知）
     */
    @AfterReturning(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    /**
     * 最终通知
     */
    @After(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after.........");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")


    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");


        //被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.........");
    }
}
