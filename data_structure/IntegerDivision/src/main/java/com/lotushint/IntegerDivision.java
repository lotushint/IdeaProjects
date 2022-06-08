package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/28 14:14
 * @package com.lotushint
 * @description 整数划分
 */
public class IntegerDivision {
    /**
     * 输出整数的划分
     *
     * @param array 临时数组（长度与要划分的整数有关）
     * @param n     要划分的整数（必须大于 0）
     * @param m     利用余下数组元素来划分未划分的数的起始下标，解释：例如 3 已经划分出 2，数组已利用了 [m = 0] 这一个空间，余下 3 - 2 = 1，则 1 继续划分保存在以[m = 1]起始的后续空间
     * @param k
     */
    public static void print(int[] array, int n, int m, int k) {
        /*
        要划分的数必须为正数
         */
        if (n > 0) {
            /*
            从最大的数开始，最小划分到 1
             */
            for (int i = n; i >= 1; i--) {
                if (m == 0) {
                    //该数开头的数已经打印完了，换行
                    System.out.println();
                    k++;
                }
                if (m == 0 || i <= array[m - 1]) {
                    array[m] = i;
                    print(array, n - i, m + 1, k);
                }
            }
        } else {
            for (int i = 0; i <= m - 1; i++) {
                if (i == (m - 1)) {
                    if (k == (m - 1)) {
                        System.out.print(array[i]);
                    } else {
                        System.out.print(array[i] + ",");
                    }
                } else {
                    System.out.print(array[i] + "+");
                }
            }
        }
    }

    /**
     * 求划分种数
     *
     * @param n 要划分的整数
     * @param m 特殊值，n小于等于m
     * @return 划分整数的种数
     */
    public static int division(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }
        if (n < m) {
            return division(n, n);
        }
        if (n == m) {
            return division(n, m - 1) + 1;
        }
        return division(n, m - 1) + division(n - m, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个要划分的数：");
        int n = sc.nextInt();
        print(new int[n], n, 0, -1);

        int result = division(n, n);
        System.out.println();
        System.out.println("对整数" + n + "的划分一共有：" + result + "种");
    }
}
