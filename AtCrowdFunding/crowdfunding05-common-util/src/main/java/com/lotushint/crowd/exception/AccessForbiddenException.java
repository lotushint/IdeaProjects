package com.lotushint.crowd.exception;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/16 18:31
 * @package com.lotushint.crowd.exception
 * @description 表示用户没有登录就访问受保护资源时抛出的异常
 */
public class AccessForbiddenException extends RuntimeException{
    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
