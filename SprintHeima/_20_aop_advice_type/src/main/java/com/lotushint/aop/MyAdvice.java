package com.lotushint.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(void com.lotushint.dao.BookDao.update())")
    private void pointCut() {
    }

    @Pointcut("execution(int com.lotushint.dao.BookDao.select())")
    private void pointCut2() {
    }

    //@Before：前置通知，在原始方法运行之前执行
//    @Before("pointCut()")
    public void before() {
        System.out.println("before advice ...");
    }

    //@After：后置通知，在原始方法运行之后执行
//    @After("pointCut2()")
    public void after() {
        System.out.println("after advice ...");
    }

    //@Around：环绕通知，在原始方法运行的前后执行
//    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        Object ret = pjp.proceed();
        System.out.println("around after advice ...");
        return ret;
    }

    //    @Around("pointCut2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用,returnn是原始操作的返回值
        Integer returnn = (Integer) pjp.proceed();
        System.out.println("around after advice ...");
        return returnn;
    }

    //@AfterReturning：返回后通知，在原始方法执行完毕后运行，且原始方法执行过程中未出现异常现象
//    @AfterReturning("pointCut2()")
    public void afterReturning() {
        System.out.println("afterReturning advice ...");
    }

    //@AfterThrowing：抛出异常后通知，在原始方法执行过程中出现异常后运行
    @AfterThrowing("pointCut2()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice ...");
    }
}
