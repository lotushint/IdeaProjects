package com.lotushint.study.chapter04.one_13;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/26 13:23
 * @package com.lotushint.study.chapter04.one_13
 * @description float 和 double 类型数据的四舍五入
 */
public class RoundingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        System.out.println(
                "Math.round(above): " + Math.round(above));
        System.out.println(
                "Math.round(below): " + Math.round(below));
        System.out.println(
                "Math.round(fabove): " + Math.round(fabove));
        System.out.println(
                "Math.round(fbelow): " + Math.round(fbelow));
    }
}

