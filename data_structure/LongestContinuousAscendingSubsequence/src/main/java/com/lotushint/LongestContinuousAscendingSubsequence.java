package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/3 15:25
 * @package com.lotushint
 * @description 最长连续上升子序列
 */
public class LongestContinuousAscendingSubsequence {
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
        LongestContinuousAscendingSubsequenceHandler handler = LongestContinuousAscendingSubsequenceHandler.getInstance(array);
        int[] s = handler.getSequence();
        System.out.println("最长连续上升子序列的维护数组:");
        LongestContinuousAscendingSubsequenceHandler.printArray(s);
        System.out.println();
        System.out.println("最长连续上升子序列:");
        LongestContinuousAscendingSubsequenceHandler.printArray(array, LongestContinuousAscendingSubsequenceHandler.maxSIndex - s[LongestContinuousAscendingSubsequenceHandler.maxSIndex] + 1, LongestContinuousAscendingSubsequenceHandler.maxSIndex + 1);
    }
}

/**
 * 求解最长连续上升子序列类
 */
class LongestContinuousAscendingSubsequenceHandler {
    private static volatile LongestContinuousAscendingSubsequenceHandler instance;
    private static int[] array;
    /**
     * s[i]最大值的索引 i
     */
    public static int maxSIndex = 1;

    /**
     * 输入一个数组
     *
     * @param array
     */
    private LongestContinuousAscendingSubsequenceHandler(int[] array) {
        LongestContinuousAscendingSubsequenceHandler.array = array;
    }

    /**
     * @return 数组的最长连续子序列维护数组
     */
    public int[] getSequence() {
        int[] s = new int[array.length];
        s[0] = 1;
        int max = s[0];
        for (int i = 1; i < array.length; i++) {
            //后面的元素比它前面的大
            if (array[i] > array[i - 1]) {
                s[i] = s[i - 1] + 1;
            } else {
                s[i] = 1;
            }
            if (s[i] > max) {
                max = s[i];
                maxSIndex = i;
            }
        }
        System.out.println("最长连续子序列的长度为：" + max);
        return s;
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
        private static final LongestContinuousAscendingSubsequenceHandler INSTANCE = new LongestContinuousAscendingSubsequenceHandler(array);
    }

    public static synchronized LongestContinuousAscendingSubsequenceHandler getInstance(int[] array) {
        LongestContinuousAscendingSubsequenceHandler.array = array;
        return HandlerInstance.INSTANCE;
    }
}