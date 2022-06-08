package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/8 20:30
 * @package com.lotushint
 * @description 全排列问题递归方式
 */
public class FullArray {
    /**
     * 输入 n 个数
     *
     * @param n       输入元素的个数
     * @param strings 将输入的元素保存的位置
     */
    public static void input(int n, String[] strings) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
    }

    /**
     * 打印所有排列
     *
     * @param strings 字符串
     * @param start   开始下标
     * @param end     结束下标
     */
    public static void printArray(String[] strings, int start, int end) {
        if (start == end) {
            System.out.print("{");
            for (int i = 0; i < strings.length - 1; i++) {
                System.out.print(strings[i] + ",");
            }
            System.out.println(strings[strings.length - 1] + "}");
        } else {
            for (int i = start; i <= end; i++) {
                swap(strings, i, start);
                printArray(strings, start + 1, end);
                swap(strings, i, start);
            }
        }
    }

    /**
     * 交换两个数组元素
     *
     * @param strings 数组
     * @param i       第一个元素下标
     * @param j       第二个元素下标
     */
    public static void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 集合元素的个数
         */
        int n = scanner.nextInt();
        /**
         * 保存输入的元素
         */
        String[] strings = new String[n];
        input(n, strings);
        printArray(strings, 0, strings.length - 1);
    }
}
