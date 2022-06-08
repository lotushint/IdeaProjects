package com.lotushint.quicksort;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/15 19:52
 * @package com.lotushint.quicksort
 * @description 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] unsorted = new int[]{0, 1, 5, 36, 51, 4, 2, 15, 7, 45};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组元素的个数：");
        int n = scanner.nextInt();
        int[] unsorted = inputArray(n);
        System.out.println("排序前：");
        printArray(unsorted);
        int[] sorted = quickSort(unsorted, 0, unsorted.length - 1);
        System.out.println("排序后：");
        printArray(sorted);
    }

    /**
     * 输入数组
     *
     * @param n 数组元素个数
     * @return 具有 n个数组元素的数组
     */
    static int[] inputArray(int n) {
        int[] array = new int[n];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + n + "个数组元素：");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    /**
     * 输出数组
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
     * 交换数组中两个元素的位置
     *
     * @param array 数组
     * @param i     数组元素的下标
     * @param j     数组元素的下标
     */
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 划分整理数组为为三部分：基准元素的左部分（都比基准元素小），基准元素（选定array[start]为基准元素），基准元素的左部分（都比基准元素大）
     *
     * @param array 数组
     * @param start 子数组开始下标
     * @param end   子数组结束下标
     * @return 基准元素的下标
     */
    static int partition(int[] array, int start, int end) {
        /**
         *基准元素
         */
        int selectedElement = array[start];
        while (start < end) {
            /*
            找到第一个小于基准元素的数
            */
            while (start < end && selectedElement <= array[end]) {
                --end;
            }
            swap(array, start, end);
            /*
            找到第一个大于基准元素的数
             */
            while (start < end && selectedElement >= array[start]) {
                ++start;
            }
            swap(array, start, end);
        }
        return start;
    }

    /**
     * 快速排序
     *
     * @param array 要排序的数组
     * @param start 数组的起始下标
     * @param end   数组的结束下标
     */
    static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int selectedElementIndex = partition(array, start, end);
            quickSort(array, start, selectedElementIndex - 1);
            quickSort(array, selectedElementIndex + 1, end);
        }
        return array;
    }
}