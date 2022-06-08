package com.lotushint.study.chapter04.one_5;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 18:44
 * @package com.lotushint.study.chapter03
 * @description 检查对象是否相等2
 * 若想对比两个对象的实际内容是否相同，又该如何操作呢？
 * 此时，必须使用所有对象都适用的特殊方法equals()。但这个方法不适用于“主类型”，那些类型直接使用==和!=即可。
 */
public class EqualsMethod {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1.equals(n2));
    }
}
