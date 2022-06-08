package com.lotushint.study.chapter04.one_1;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 17:27
 * @package com.lotushint.study.Chapter2
 * @description
 */
public class Assignment {
  public static void main(String[] args) {
    Number n1 = new Number();
    Number n2 = new Number();
    n1.i = 9;
    n2.i = 47;
    System.out.println("1:  n1.i:  " + n1.i + ",  n2.i:  " + n2.i);
    /*
    看来改变n1的同时也改变了n2！这是由于无论n1还是n2都包含了相同的句柄，它指向相同的对象（最初的句柄位于n1内部，指向容纳了值9的一个对象。在赋值过程中，那个句柄实际已经丢失；它的对象会由“垃圾收集器”自动清除）。
    这种特殊的现象通常也叫作“别名”，是Java操作对象的一种基本方式。但假若不愿意在这种情况下出现别名，又该怎么操作呢？可放弃赋值，并写入下述代码：
    n1.i = n2.i;
    */
    n1 = n2;
    System.out.println("2:  n1.i:  " + n1.i + ",  n2.i:  " + n2.i);
    n1.i = 27;
    System.out.println("3:  n1.i:  " + n1.i + ",  n2.i:  " + n2.i);
  }
}

class Number {
  int i;
}
