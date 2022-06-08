package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/21 10:23
 * @package com.lotushint
 * @description 0-1背包问题（动态规划法）
 */
public class Knapsack {
    public static void main(String[] args) {
//        int[] weight = new int[]{2, 2, 6, 5, 4};
//        int[] value = new int[]{6, 3, 5, 4, 6};
//        int capacity = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入背包的容量：");
        int capacity = scanner.nextInt();
        System.out.println("请输入物品的数量：");
        int quantity = scanner.nextInt();
        System.out.println("请输入物品的重量：");
        int[] weight = input(quantity);
        System.out.println("请输入物品的价值：");
        int[] value = input(quantity);

        int maxValue = pack(weight, value, capacity);
        System.out.println();
        System.out.print("当背包容量为" + capacity + "时能装物品的最大价值为：");
        System.out.print(maxValue);
    }

    /**
     * 输入数组元素
     *
     * @param quantity 数组元素的数量
     * @return 数组
     */
    public static int[] input(int quantity) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    /**
     * 输出数组元素
     *
     * @param array 数组
     * @return true Or false
     */
    public static boolean output(int[][] array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
        return true;
    }

    /**
     * 将物品进行装包
     *
     * @param weight   每个物品的重量
     * @param value    每个物品的价值
     * @param capacity 背包的总容量
     * @return 最大价值
     */
    public static int pack(int[] weight, int[] value, int capacity) {
        if (capacity == 0 || weight.length == 0) {
            return 0;
        }
        int len = weight.length;
        /**
         * 考虑 i 个物品后容量为 j 的背包所能装物品的最大价值
         */
        int[][] m = new int[len][capacity + 1];
        for (int j = 1; j < capacity + 1; j++) {
            for (int i = 0; i < len; i++) {
                //如果当前宝石重量大于整个背包的承重
                if (weight[i] > j) {
                    //如果当前只考虑了第一块宝石
                    if (i == 0) {
                        m[i][j] = 0;
                    } else {
                        m[i][j] = m[i - 1][j];
                    }
                } else {
                    //如果当前只考虑了第一块宝石
                    if (i == 0) {
                        m[i][j] = value[i];
                    } else {
                        m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
        }
        System.out.println("考虑 i 个物品后容量为 j 的背包所能装物品的最大价值表（从上到下，从左到右计算）：");
        output(m);
        return m[len - 1][capacity];
    }

}
