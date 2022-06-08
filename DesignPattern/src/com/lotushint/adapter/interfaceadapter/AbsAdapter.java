package com.lotushint.adapter.interfaceadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 11:40
 * @package com.lotushint.adapter.interfaceadapter
 * @description
 */
public abstract class AbsAdapter implements Interface4 {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    /**
     *抽象类如果不实现接口的全部方法（把下面m4注释掉），则client类中使用时要重写接口方法
     */
    @Override
    public void m4() {

    }
}
