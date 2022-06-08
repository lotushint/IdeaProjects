package com.lotus.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author hefan
 * @package com.lotus.spring5
 * @date 2021/8/21 15:03
 * @description
 */
public class jdkProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(jdkProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result:"+result);
    }
}
/**
 * 创建代理对象代码
 */
class UserDaoProxy implements InvocationHandler {

    /**
     * 1 把创建的是谁的代理对象，把谁传递过来
     *   有参数构造传递
     */
    private Object obj;
    public UserDaoProxy(Object obj) {//可以直接写UserDaoImpl userDao,为了更加通用写Object obj
        this.obj = obj;
    }

    /**
     *  增强的逻辑
     *  多个方法增强可用switch语句根据method.getName()方法判断！！！！！！
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行.....,方法名:"+method.getName()+" :传递的参数:"+ Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("方法之后执行....."+obj);
        return res;
    }
}
