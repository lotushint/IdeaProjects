package com.lotushint.singleton.type3;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/1 21:00
 * @package com.lotushint.singleton.type3
 * @description 懒汉式(线程不安全)
 *
 * 1) 起到了Lazy Loading的效果，但是只能在单线程下使用。
 * 2) 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例（同时也不是单例模式了）。所以在多线程环境下不可使用这种方式
 * 3) 结论：在实际开发中，不要使用这种方式
 */
public class SingletonTest03 {
    public static void main(String[] args) {
        System.out.println("懒汉式1，线程不安全~");
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
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
