package com.meituan;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/25 11:14
 * @package com.meituan
 * @description 第13组 懒惰的小美
 */
public class ArrayInverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {//列
            for (int j = 0; j < n; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }
}
