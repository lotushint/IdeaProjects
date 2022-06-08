package com.lotushint.study.chapter04.summary;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/26 13:37
 * @package com.lotushint.study.chapter04.summary
 * @description 厉害了！内存溢出
 */
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
}

