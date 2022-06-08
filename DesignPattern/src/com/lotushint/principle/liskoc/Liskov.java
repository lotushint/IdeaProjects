package com.lotushint.principle.liskoc;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/20 14:12
 * @package com.lotushint.principle.liskoc
 * @description 里式替换原则
 */
public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");
        B b = new B();
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

class A {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * 增加了一个新功能，两数和再加9
 */
class B extends A {
    @Override
    public int func1(int a, int b) {//重写了A类方法，可能是无意识的
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}