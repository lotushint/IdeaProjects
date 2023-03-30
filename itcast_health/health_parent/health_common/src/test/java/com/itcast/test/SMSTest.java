package com.itcast.test;

import com.itheima.utils.SMSUtils;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/30 18:54
 * @package com.itcast.test
 * @description
 */
public class SMSTest {
    public static void main(String[] args)throws Exception {
        SMSUtils.sendShortMessage("SMS_275295148","18479522791","2456");
    }
}
