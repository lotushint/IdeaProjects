package com.lotushint.crowd.exception;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/16 10:19
 * @package com.lotushint.crowd.exception
 * @description 登录失败抛出的异常
 */
public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }
}
