package com.itcast.test;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.itheima.utils.SMSUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/30 18:54
 * @package com.itcast.test
 * @description
 */
public class SMSTest {
    public static void main(String[] args) throws Exception {
        SMSUtils.sendShortMessage("SMS_275345349","18479522791","2456");
    }
}
