package com.lotushint.adapter.classadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 8:33
 * @package com.lotushint.adapter.classadapter
 * @description 被适配的类
 */
public class Voltage220V {
    //输出220V的电压
    public int output220V(){
        int src = 220;
        System.out.println("电压" + src +"伏");
        return src;
    }
}
