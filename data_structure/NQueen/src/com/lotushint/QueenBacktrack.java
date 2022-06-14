package com.lotushint;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/15 10:29
 * @package com.lotushint
 * @description N皇后（回溯法）
 */
public class QueenBacktrack {
    /**
     * 棋盘的行数
     */
    private static int n;
    /**
     * 排法结果种数
     */
    private static int count = 0;
    /**
     * 结果
     */
    private static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入棋盘的规模 n:");
        n = scanner.nextInt();
        result = new int[n];
        //从第一行开始向下查找
        search(0);
        System.out.println("结果数量：" + count);
    }

    /**
     * 放置 queen
     *
     * @param i 当前行
     */
    public static void search(int i) {
        if (i >= n) {
            //i >= n,所有行全部找完，一组查找结束
            count++;
            System.out.println("结果" + count + ":" + Arrays.toString(result));
        } else {
            //遍历所有列
            for (int j = 0; j < n; j++) {
                //将该列放置 queen
                result[i] = j;
                //如果将行的每一列都找不到存放点，则进行回朔查找。
                if (ifPlace(result, i)) {
                    //可存放，继续下一行
                    search(i + 1);
                }
            }
        }
    }

    /**
     * 检测是否可放置
     *
     * @param array 结果
     * @param i     当前行
     * @return false为不可放置，true为可放置
     */
    public static boolean ifPlace(int[] array, int i) {
        /*
        遍历所有行数
         */
        for (int j = 0; j < i; j++) {
            //列存在两个皇后
            if (array[j] == array[i]) {
                return false;
            }
            //同一斜线存在两个皇后，斜率为 1 或 -1
            if ((Math.abs(j - i)) == Math.abs(array[j] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
