package com.lotushint.singleton.type5;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/2 19:32
 * @package com.lotushint.singleton.type5
 * @description 懒汉式(线程安全：本意，实际做不到 ， 同步代码块)--------不能使用！！！
 * 1. 这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，改为同步产生实例化的的代码块
 * 2. 但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
 * 3. 结论：在实际开发中，`不能`使用这种方式
 */
public class SingletonTest05 {
    public static void main(String[] args) {
        System.out.println("懒汉式3，线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //true
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode());
        System.out.println("instance2.hashCode()=" + instance2.hashCode());
    }
}

class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}