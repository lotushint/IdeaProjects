package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/6/16 14:41
 * @package com.xuecheng.base.exception
 * @description 和前端约定返回的异常信息模型
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
