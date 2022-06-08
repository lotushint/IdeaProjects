package com.lotushint.study.chapter04.one_5;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 18:43
 * @package com.lotushint.study.chapter03
 * @description 检查对象是否相等1
 * 尽管对象的内容相同，句柄却是不同的，而==和!=比较的正好就是对象句柄。所以输出结果实际上先是false，再是true。
 */
public class Equivalence {
  public static void main(String[] args) {
    Integer n1 = new Integer(47);
    Integer n2 = new Integer(47);
    System.out.println(n1 == n2);
    System.out.println(n1 != n2);
  }
}
