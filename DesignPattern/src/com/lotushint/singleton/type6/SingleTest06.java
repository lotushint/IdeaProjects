package com.lotushint.singleton.type6;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/2 20:05
 * @package com.lotushint.singleton.type6
 * @description 双重检查
 */
public class SingleTest06 {
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        //true
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode());
        System.out.println("instance2.hashCode()=" + instance2.hashCode());
    }
}

class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    /**
     * 提供一静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}