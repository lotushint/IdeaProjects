package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/25 9:46
 * @package com.lotushint
 * @description 0-1背包问题（贪心法）:此算法选取的是单位价值最高的优先放进背包，其他选择策略：如价值最大的，最轻的，随机选择的
 */
public class Knapsack2 {
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
     * 对数组进行从到到小的排序（冒泡排序）
     *
     * @param weight
     * @param value
     * @param unitValue
     */
    public static void sort(int[] weight, int[] value, int[] unitValue) {
        int temp;
        //比较的次数
        for (int i = 0; i < unitValue.length - 1; i++) {
            //相邻两个数比较
            for (int j = 0; j < unitValue.length - i - 1; j++) {
                if (unitValue[j] < unitValue[j + 1]) {
                    temp = unitValue[j];
                    unitValue[j] = unitValue[j + 1];
                    unitValue[j + 1] = temp;

                    temp = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = temp;

                    temp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = temp;
                }
            }
        }
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
        int len = weight.length;
        int maxValue = 0;
        /**
         * 单位价值
         */
        int[] unitValue = new int[len];
        for (int i = 0; i < len; i++) {
            unitValue[i] = value[i] / weight[i];
        }
        sort(weight, value, unitValue);

        for (int i = 0; i < len; i++) {
            if (weight[i] > capacity) {
                break;
            } else {
                capacity -= weight[i];
                maxValue += value[i];
            }
        }
        return maxValue;
    }
}
