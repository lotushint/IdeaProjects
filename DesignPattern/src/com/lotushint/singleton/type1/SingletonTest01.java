package com.lotushint.singleton.type1;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/31 19:52
 * @package com.lotushint.singleton.type1
 * @description 饿汉式(静态常量):创建的是同一个对象实例,可能会造成内存浪费
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //true
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode());
        System.out.println("instance2.hashCode()=" + instance2.hashCode());
    }
}

class Singleton {
    /**
     * 构造器私有化，外部不能new一个对象
     */
    private Singleton() {
    }

    /**
     * 2.本类内部创建对象实例
     */
    private final static Singleton instance = new Singleton();

    /**
     * 3.提供一个共有的静态方法，返回对象实例
     *
     * @return
     */
    public static Singleton getInstance() {
        return instance;
    }
}