package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/20 7:50
 * @package com.lotushint
 * @description 矩阵连乘
 */
public class MatrixMultiplication {
    private static final int size = 100;
    static int[] p;
    /**
     * m 中存储的是计算出来的最小乘法次数，如：m[1][5]就是A1A2A3A4A5的最小乘法次数
     */
    static int[][] m;
    /**
     * s 中存储的是获取最小乘法次数的断链点，如：s[1][5]：(A1A2A3)(A4A5)
     */
    static int[][] s;
    /**
     * 矩阵的个数
     */
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的个数n : ");
        n = sc.nextInt();
        System.out.println("请依次输入每个矩阵的行数和最后一个矩阵的列数：");
        p = new int[size];
        //相邻两个p[i]为一个矩阵的行，列,相邻的两个矩阵列行相同只输入一次，如：5 x 8,8 x 6,则输入5 8 6
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        matrixChain(size);
        print(1, n);
        System.out.println();
        System.out.println("最小计算量的值为：" + m[1][n]);
    }

    static void matrixChain(int size) {
        int j;
        /*
        初始化数组
         */
        m = new int[size][size];
        s = new int[size][size];

        //矩阵连乘的规模为 r,先从两个开始划分
        for (int r = 2; r <= n; r++) {
            //r个矩阵的r-1个空隙中依次测试最优点
            for (int i = 1; i <= n - r + 1; i++) {
                j = i + r - 1;
                //对 m[][]开始赋值
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                //s[][]存储各子问题的断链点
                s[i][j] = i;
                /*
                 变换分隔位置，逐一测试，寻找最优值
                 */
                for (int k = i + 1; k < j; k++) {
                    int tempMin = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    //如果变换后的位置更优，则替换原来的分隔方法
                    if (tempMin < m[i][j]) {
                        m[i][j] = tempMin;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    static void print(int i, int j) {
        if (i == j) {
            System.out.print("A[" + i + "]");
            return;
        }
        System.out.print("(");
        print(i, s[i][j]);
        //递归1到s[1][j]
        print(s[i][j] + 1, j);
        System.out.print(")");
    }
}
