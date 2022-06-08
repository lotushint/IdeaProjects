package com.lotus.spring5.aopanno;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hefan
 * @package com.lotus.spring5.aopanno
 * @date 2021/8/26 19:45
 * @description
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {
    /**
     * 前置通知（返回通知）
     */
    @Before(value = "execution(* com.lotus.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person Before.........");
    }
}
