package com.lotushint.singleton.type8;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/4 16:50
 * @package com.lotushint.singleton.type8
 * @description 枚举
 * 1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 2) 这种方式是Effective Java作者Josh Bloch 提倡的方式
 * 3) 结论：推荐使用
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        instance.sayOK();
    }
}

/**
 * 使用枚举，可以实现单例，推荐使用
 */
enum Singleton {
    //属性
    INSTANCE;
    public void sayOK(){
        System.out.println("ok~");
    }
}