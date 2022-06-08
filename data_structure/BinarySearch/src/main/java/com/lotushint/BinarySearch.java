package com.lotushint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/14 11:53
 * @package com.lotushint
 * @description 设a[0:n-1]是已经排好序的数组。
 * 请改写二分搜索算法，使得当搜索元素x不在数组中时，返回小于x的最大元素位置i和大于x的最小元素位置j。
 * 当搜索元素在数组中的时候，i和j相同，均为x现在数组中的位置。
 */
public class BinarySearch {
    public static void main(String[] args) {
        Find find = new Find();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组10个元素：");
        int x;
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            x = scanner.nextInt();
            a[i] = x;
        }
        System.out.println("请输入要查找的数：");
        int f = scanner.nextInt();
        List list = find.find(a, f);
        System.out.println(list);
    }
}

class Find {
    /**
     * 二分查找
     *
     * @param sortedArray 已经排好序的数组
     * @param x           要查找的数
     * @return 当搜索元素x不在数组中时，返回小于x的最大元素位置i和大于x的最小元素位置j。当搜索元素在数组中的时候，i和j相同，均为x现在数组中的位置。
     */
    List find(int[] sortedArray, int x) {
        List list = new ArrayList();
        int left = 0, right = sortedArray.length - 1, mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (sortedArray[mid] == x) {
                list.add(mid);
                return list;
            } else if (sortedArray[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (x > sortedArray[sortedArray.length - 1]) {
            list.add(mid);
            list.add(mid + 1);
        } else {
            list.add(mid - 1);
            list.add(mid);
        }
        return list;
    }
}
