package com.lotushint.singleton.type4;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/1 21:31
 * @package com.lotushint.singleton.type4
 * @description 懒汉式(线程安全 ，同步方法)
 * 1. 解决了线程不安全问题
 * 2. 效率太低了，可能有很多个线程需要获取实例，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低
 * 3. 结论：在实际开发中，不推荐使用这种方式
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        System.out.println("懒汉式2，线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //true
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode());
        System.out.println("instance2.hashCode()=" + instance2.hashCode());
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 提供一个静态的共有方法，当使用到该方法时，才去创建该 instance
     * 加入同步处理的代码，解决线程安全问题
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
