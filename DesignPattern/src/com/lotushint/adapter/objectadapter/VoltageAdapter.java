package com.lotushint.adapter.objectadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 8:40
 * @package com.lotushint.adapter.classadapter
 * @description 适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != voltage220V) {
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器，进行适配~~~");
            dst = src / 44;
            System.out.println("适配完成，输出的电压为=" + dst);
        }
        return dst;
    }
}
