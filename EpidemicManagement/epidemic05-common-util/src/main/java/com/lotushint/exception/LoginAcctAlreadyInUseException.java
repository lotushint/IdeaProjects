package com.lotushint.exception;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/19 15:37
 * @package com.lotushint.crowd.exception
 * @description 保存或更新Admin时如果检测到登录账号重复抛出这个异常
 */
public class LoginAcctAlreadyInUseException extends RuntimeException {

    public LoginAcctAlreadyInUseException() {
        super();
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

}

