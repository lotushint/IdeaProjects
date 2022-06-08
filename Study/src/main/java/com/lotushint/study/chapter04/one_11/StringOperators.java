package com.lotushint.study.chapter04.one_11;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/26 13:09
 * @package com.lotushint.study.chapter04.one_11
 * @description
 */
public class StringOperators {
    public static void main(String[] args) {
        int x = 0, y = 1, z = 2;
        String s = "x, y, z ";
        System.out.println(s + x + y + z);
        // 将 x 转换为字符串
        System.out.println(x + " " + s);
        s += "(summed) = ";
        // 级联操作
        System.out.println(s + (x + y + z));
        // Integer.toString()方法的简写:
        System.out.println("" + x);
    }
}

