package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/4 13:01
 * @package com.lotushint
 * @description 最长上升子序列
 */
public class LongestAscendingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("请输入数组的个数：");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("请输入" + n + "个数：");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        LongestAscendingSubsequenceHandler handler = LongestAscendingSubsequenceHandler.getInstance(array);
        int[] s = handler.getSequence();
        System.out.println("最长上升子序列的维护数组:");
        LongestAscendingSubsequenceHandler.printArray(s);
//        System.out.println();
//        System.out.println("最长上升子序列:");
//        LongestAscendingSubsequenceHandler.printArray(array, LongestAscendingSubsequenceHandler.maxSIndex - s[LongestAscendingSubsequenceHandler.maxSIndex] + 1, LongestAscendingSubsequenceHandler.maxSIndex + 1);
    }
}

/**
 * 求解最长连续上升子序列类
 */
class LongestAscendingSubsequenceHandler {
    private static volatile LongestAscendingSubsequenceHandler instance;
    private static int[] array;
    /**
     * dp[i]最大值的索引 i
     */
    public static int maxSIndex = 1;

    /**
     * 输入一个数组
     *
     * @param array
     */
    private LongestAscendingSubsequenceHandler(int[] array) {
        LongestAscendingSubsequenceHandler.array = array;
    }

    /**
     * @return 数组的最长连续子序列维护数组 dp
     */
    public int[] getSequence() {
        /**
         * 维护数组
         */
        int[] dp = new int[array.length];
        dp[0] = 1;
        /**
         * 最长上升子序列的长度
         */
        int max = 1;

        for (int i = 1; i < dp.length; i++) {
            /**
             * 当前dp中最长上升子序列的长度
             */
            int maxTemp = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = dp[j] + 1;

                    if (maxTemp < dp[i]) {
                        //第一次外循环完最后保存最大的序列值到dp[i]
                        maxTemp = dp[i];
                    }
                }
            }
            //保存最大的序列值到dp[i]
            dp[i] = maxTemp;
            if (max < dp[i]) {
                max = dp[i];
                maxSIndex = i;
            }
        }
        System.out.println("最长连续子序列的长度为：" + max);
        return dp;
    }


    /**
     * 打印数组索引元素
     *
     * @param array
     */
    public static void printArray(int[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 打印指定范围内的数组元素
     *
     * @param array 数组
     * @param start 起始索引
     * @param end   结束索引(不包括该索引处的值)
     */
    public static void printArray(int[] array, int start, int end) {
        for (; start < end; start++) {
            System.out.print(array[start] + " ");
        }
    }

    private static class HandlerInstance {
        private static final LongestAscendingSubsequenceHandler INSTANCE = new LongestAscendingSubsequenceHandler(array);
    }

    public static synchronized LongestAscendingSubsequenceHandler getInstance(int[] array) {
        LongestAscendingSubsequenceHandler.array = array;
        return HandlerInstance.INSTANCE;
    }
}