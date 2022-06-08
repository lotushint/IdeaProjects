package com.lotushint.study.chapter04.one_13;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/26 13:18
 * @package com.lotushint.study.chapter04.one_13
 * @description
 */
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long)i;
        lng = i; // 没有必要的类型提升
        long lng2 = (long)200;
        lng2 = 200;
        // 类型收缩
        i = (int)lng2; // Cast required
    }
}

