package com.lotushint.Book.utils;

import com.lotushint.Book.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author hefan
 * @package com.lotushint.Book.utils
 * @date 2021/11/10 22:07
 * @description
 */
public class WebUtils {
    /**
     * 第一个参数写成HttpServletRequest request，耦合度高：dao层和service层没有HttpServlet
     * 用<T> T就不需要类型转换了
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前："+bean);
            //把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,value);
            System.out.println("注入之后："+bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
