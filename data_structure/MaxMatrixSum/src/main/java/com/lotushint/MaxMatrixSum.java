package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/14 12:39
 * @package com.lotushint
 * @description 最大矩阵和
 * 示例：<br>
 * 输入：<br>
 * 4 4<br>
 * 0 -2 -7  0<br>
 * 9  2 -6  2<br>
 * -4  1 -4  1<br>
 * -1  8  0 -2<br>
 * <br>
 * 输出：<br>
 * 15<br>
 */
public class MaxMatrixSum {
    public static void main(String[] args) {
        /**
         * m x n的矩阵，sum为临时最大值,最大子矩阵的和
         */
        int m, n, sum, result = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的行数和列数（空格隔开）：");
        m = sc.nextInt();
        n = sc.nextInt();
        /**
         * 原矩阵
         */
        int[][] matrix = new int[m][n];
        /**
         * 假设的最大子矩阵的每列元素的和
         */
        int[] columnElementSum;
        System.out.println("请输入矩阵的元素：");
        //输入矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //假设最大子矩阵第一行是 i 行
        for (int i = 0; i < m; i++) {
            //清 0
//            for (int c = 0; c < columnElementSum.length; c++) {
//                columnElementSum[c] = 0;
//            }
            columnElementSum = new int[m];

            //每次加一行，扩大最大子矩阵的搜索范围，最大子矩阵在 i 到 j 行
            for (int j = i; j < m; j++) {
                //每次加一列的和 columnElementSum[k],i~j行的矩阵和
                sum = 0;
                for (int k = 0; k < m; k++) {
                    columnElementSum[k] = columnElementSum[k] + matrix[j][k];
                    //加一列的和 columnElementSum[k]
                    sum = sum + columnElementSum[k];
                    //第 k 列之前子矩阵和为负，则最大和sum=b[k];
                    if (sum < columnElementSum[k]) {
                        sum = columnElementSum[k];
                    }
                    if (sum > result) {
                        result = sum;
                    }
                }
            }
        }
        System.out.println("最大子矩阵的和：" + result);
    }
}
