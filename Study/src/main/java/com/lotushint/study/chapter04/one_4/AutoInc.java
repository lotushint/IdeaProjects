package com.lotushint.study.chapter04.one_4;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 18:31
 * @package com.lotushint.study.chapter03
 * @description Demonstrates the ++ and -- operators
 */
public class AutoInc {
  public static void main(String[] args) {
    int i = 1;
    prt("i  :  " + i);
    // Pre-incrementprt
    prt("++i  :  " + ++i);
    // Post-incrementprt
    prt("i++  :  " + i++);

    prt("i  :  " + i);
    // Pre-decrementprt
    prt("--i  :  " + --i);
    // Post-decrementprt
    prt("i--  :  " + i--);
    prt("i  :  " + i);
  }

  static void prt(String s) {
    System.out.println(s);
  }
}
