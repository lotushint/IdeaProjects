package com.lotushint.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/8 19:34
 * @package com.lotushint.aop
 * @description
 */
@Component
@Aspect
public class MyAdvice {
    //切入点表达式标准格式：动作关键字（访问修饰符 返回值 包名.类/接口名.方法名（参数）异常名）
    //一般描述到接口：BookDao而不是实现类：BookDaoImpl,因为要尽量降低耦合
    @Pointcut("execution(void com.lotushint.dao.BookDao.update())")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }
}
