package com.lotushint.adapter.objectadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 8:45
 * @package com.lotushint.adapter.classadapter
 * @description
 */
public class Phone {
    /**
     * 充电
     */
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("电压为5V,可以充电~~~");
        }else if (iVoltage5V.output5V() > 5){
            System.out.println("电压大于5V,不能充电~~~");
        }
    }
}
