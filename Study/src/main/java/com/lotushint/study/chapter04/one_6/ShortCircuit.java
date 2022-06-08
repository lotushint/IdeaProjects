package com.lotushint.study.chapter04.one_6;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/22 19:06
 * @package com.lotushint.study.chapter03.one_6
 * @description Demonstrates short-circuiting behavior with logical operators. 短路
 * 第一个测试生成一个true结果，所以表达式求值会继续下去。
 * 然而，第二个测试产生了一个false结果。
 * 由于这意味着整个表达式肯定为false，所以为什么还要继续剩余的表达式呢？
 * 这样做只会徒劳无益。事实上，“短路”一词的由来正种因于此。
 * 如果一个逻辑表达式的所有部分都不必执行下去，那么潜在的性能提升将是相当可观的。
 */
public class ShortCircuit {
    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result:  " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result:  " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result:  " + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        if (test1(0) && test2(2) && test3(2)) {
            System.out.println("expression  is  true");
        } else {
            System.out.println("expression  is  false");
        }
    }
}
