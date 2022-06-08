package com.meituan;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/24 11:09
 * @package com.meituan
 * @description 小美的跳方格
 */
public class TiaoFangGe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] a = new int[n][n];
        //输入方格数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        getMinDistance(a, k);

    }


    static void getMinDistance(int[][] array, int k) {
        int length = array[0].length;
        int[][] dis = new int[length * length][k + 1];
        Integer x = null;
        Integer y = null;

        for (int c = 1; c <= k; c++) {

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    //c:跳 1
                    if (array[i][j] == 1) {
                        x = i;
                        y = j;
                    } else if (array[i][j] == c && x != null && y != null) {
                        //c:跳2,3,4，...,k
                        if (dis[i * length + j][c] > dis[x * length + y][c - 1] + abs(x - i) + abs(y - j)) {
                            dis[i * length + j][c] = dis[x * length + y][c - 1] + abs(x - i) + abs(y - j);
                        }
                    }
                }
            }
        }
        k++;
    }
}
