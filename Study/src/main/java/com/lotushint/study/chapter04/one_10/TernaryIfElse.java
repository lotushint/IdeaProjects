package com.lotushint.study.chapter04.one_10;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/26 13:06
 * @package com.lotushint.study.chapter04.one_10
 * @description
 */
// operators/TernaryIfElse.java
public class TernaryIfElse {

    static int ternary(int i) {
        return i < 10 ? i * 100 : i * 10;
    }

    static int standardIfElse(int i) {
        if (i < 10) {
            return i * 100;
        } else {
            return i * 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(ternary(10));
        System.out.println(standardIfElse(9));
        System.out.println(standardIfElse(10));
    }
}

