package com.lotushint.study.chapter04.one_5;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 18:46
 * @package com.lotushint.study.chapter03
 * @description 检查对象是否相等3
 * 此时的结果又变回了false！这是由于equals()的默认行为是比较句柄。
 * 所以除非在自己的新类中改变了equals()，否则不可能表现出我们希望的行为。
 * 不幸的是，要到第7章才会学习如何改变行为。但要注意equals()的这种行为方式同时或许能够避免一些“灾难”性的事件。
 * 大多数Java类库都实现了equals()，所以它实际比较的是对象的内容，而非它们的句柄。
 */
public class EqualsMethod2 {
  public static void main(String[] args) {
    Value v1 = new Value();
    Value v2 = new Value();
    v1.i = v2.i = 100;
    System.out.println(v1.equals(v2));
  }
}

class Value {
  int i;
}
