package com.lotushint.adapter.interfaceadapter;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/22 11:43
 * @package com.lotushint.adapter.interfaceadapter
 * @description
 */
public class Client {
    public static void main(String[] args) {
        //抽象类不能被实例化，所以不是 new 抽象类，可以理解为创造了一个匿名子类,相当于new了一个匿名内部类继承了抽象类，重写了抽象类的方法
        AbsAdapter absAdapter = new AbsAdapter() {
            /**
             * 只需要去覆盖我们需要使用的接口方法
             */
            @Override
            public void m1() {
                super.m1();
                System.out.println("使用了m1的方法");
            }
        };
        absAdapter.m1();
    }
}
