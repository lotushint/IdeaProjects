package com.itheima.reggie.common;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/13 18:39
 * @package com.itheima.reggie.common
 * @description 自定义业务异常类
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
