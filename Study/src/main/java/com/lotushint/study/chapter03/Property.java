package com.lotushint.study.chapter03;

import java.util.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/20 17:43
 * @package com.lotushint.study
 * @description 2
 */
public class Property {
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties p = System.getProperties();
        p.list(System.out);
        System.out.println("---  Memory  Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total  Memory  =  " + rt.totalMemory() + "  Free  Memory  =  " + rt.freeMemory());
    }
}