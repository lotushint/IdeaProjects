package com.lotushint.mergesort;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/15 18:36
 * @package com.lotushint.mergesort
 * @description 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] unsorted = new int[]{0, 1, 5, 36, 51, 4, 2, 15, 7, 45};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组元素的个数：");
        int n = scanner.nextInt();
        int[] unsorted = inputArray(n);
        System.out.println("排序前：");
        printArray(unsorted);
        int[] sorted = mergeSort(unsorted);
        System.out.println("排序后：");
        printArray(sorted);
    }

    /**
     * 输入数组元素
     *
     * @param n 数组元素的个数
     */
    static int[] inputArray(int n) {
        int[] result = new int[n];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + n + "个数组元素（每个元素以空格分隔）：");
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextInt();
        }
        return result;
    }

    /**
     * 打印数组元素
     *
     * @param array 数组
     */
    static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    /**
     * 归并排序
     *
     * @param unsorted 未排序的数组
     * @return
     */
    static int[] mergeSort(int[] unsorted) {
        /*
        数组没有元素或只有一个元素，直接返回该数组
         */
        if (unsorted.length == 0 || unsorted.length == 1) {
            return unsorted;
        }
        /**
         * 将数组分成左右两部分，尽量使两部分相差一个元素以内
         */
        int mid = unsorted.length / 2;
        return merge(mergeSort(getRangeArray(unsorted, 0, mid)), mergeSort(getRangeArray(unsorted, mid, unsorted.length)));
    }


    /**
     * 对两个数组合并成一个有序的数组
     *
     * @param left  左数组
     * @param right 右数组
     * @return 左右数组合并成的一个有序的数组
     */
    static int[] merge(int[] left, int[] right) {
        /**
         * 将两个数组合并排序后数组
         */
        int[] result = new int[left.length + right.length];
        /**
         * result的索引
         */
        int resultIndex;
        /**
         * 两个数组的索引:i: left,j: right
         */
        int i, j;
        for (resultIndex = 0, i = 0, j = 0; resultIndex < result.length; resultIndex++) {
            if (j >= right.length) {
                result[resultIndex] = left[i++];
            } else if (i >= left.length) {
                result[resultIndex] = right[j++];
            } else if (left[i] > right[j]) {
                result[resultIndex] = right[j++];
            } else if (left[i] < right[j]) {
                result[resultIndex] = left[i++];
            }
        }
        return result;
    }

    /**
     * 获取指定数组指定范围的元素
     *
     * @param array 原数组
     * @param start 开始索引
     * @param end   结束索引
     * @return 获取索引在[start, end)内的元素组成的数组
     */
    static int[] getRangeArray(int[] array, int start, int end) {
        int[] result = new int[end - start];
        for (int resultIndex = 0; start < end; ) {
            result[resultIndex++] = array[start++];
        }
        return result;
    }
}
