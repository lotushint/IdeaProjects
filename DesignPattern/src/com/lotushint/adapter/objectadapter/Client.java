package com.lotushint.adapter.objectadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 8:48
 * @package com.lotushint.adapter.classadapter
 * @description
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("===对象适配器模式===");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
