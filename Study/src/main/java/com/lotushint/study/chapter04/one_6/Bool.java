package com.lotushint.study.chapter04.one_6;

import java.util.Random;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 18:56
 * @package com.lotushint.study.chapter03.one_6
 * @description Relational and logical operators
 */
public class Bool {
  public static void main(String[] args) {
    Random rand = new Random();
    int i = rand.nextInt() % 100;
    int j = rand.nextInt() % 100;
    prt("i  =  " + i);
    prt("j  =  " + j);
    prt("i  >  j  is  " + (i > j));
    prt("i  <  j  is  " + (i < j));
    prt("i  >=  j  is  " + (i >= j));
    prt("i  <=  j  is  " + (i <= j));
    prt("i  ==  j  is  " + (i == j));
    prt("i  !=  j  is  " + (i != j));
    /*
    错误！
    Treating  an  int  as  a  boolean  is  not  legal  Java:
       prt("i  &&  j  is  "  +  (i  &&  j));
       prt("i  ||  j  is  "  +  (i  ||  j));
       prt("!i  is  "  +  !i);
    */
    prt("(i  <  10)  &&  (j  <  10)  is  " + ((i < 10) && (j < 10)));
    prt("(i  <  10)  ||  (j  <  10)  is  " + ((i < 10) || (j < 10)));
  }

  static void prt(String s) {
    System.out.println(s);
  }
}
