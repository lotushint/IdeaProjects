package com.lotushint.study.chapter04.one_1;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 17:38
 * @package com.lotushint.study.chapter3
 * @description 将一个对象传递到方法内部时，也会产生别名现象。
 */
public class PassObject {
  static void f(Letter y) {
    y.c = 'z';
  }

  public static void main(String[] args) {
    Letter x = new Letter();
    x.c = 'a';
    System.out.println("1:  x.c:  " + x.c);
    f(x);
    System.out.println("2:  x.c:  " + x.c);
  }
}

class Letter {
  char c;
}
