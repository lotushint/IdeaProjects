package com.lotushint.adapter.classadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 8:40
 * @package com.lotushint.adapter.classadapter
 * @description 适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        //获取到220V的电压
        int srcV = output220V();
        //转成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
