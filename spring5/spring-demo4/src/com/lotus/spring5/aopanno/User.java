package com.lotus.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author hefan
 * @package com.lotus.spring5.aopanno
 * @date 2021/8/26 11:26
 * @description 被增强的类
 */
@Component
public class User {

    public void add(){
        System.out.println("add........");
    }
}
