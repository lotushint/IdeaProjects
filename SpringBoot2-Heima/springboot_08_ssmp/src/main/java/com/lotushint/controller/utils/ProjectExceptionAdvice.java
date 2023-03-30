package com.lotushint.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/21 15:49
 * @package com.lotushint.controller.utils
 * @description
 */
//作为springmvc的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex) {
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        return new R(false, "服务器故障，请稍后再试！");
    }
}
