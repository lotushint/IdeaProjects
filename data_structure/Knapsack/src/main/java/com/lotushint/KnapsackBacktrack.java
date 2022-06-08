package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/11 7:53
 * @package com.lotushint
 * @description 01背包问题（回溯法）
 */
public class KnapsackBacktrack {
    /**
     * 物品的重量
     */
    public static int[] weight;
    /**
     * 物品的价值
     */
    public static int[] value;
    /**
     * 假设选择 hypotheticalChoice[i] 装入背包
     */
    public static int[] hypotheticalChoice;
    /**
     * 选择 choice[i] 装入背包
     */
    public static int[] choice;

    /**
     * 当前背包内物品的总重量
     */
    static int currentWeight = 0;
    /**
     * 当前背包内物品的总价值
     */
    static int currentValue = 0;
    /**
     * 背包能装的物品的最大价值
     */
    static int maxValue = 0;
    /**
     * 背包的容量
     */
    static int capacity = 0;
    /**
     * 物品的数量
     */
    static int quantity = 0;

    /**
     * 回溯法求解 0-1背包问题
     *
     * @param depth 数的深度
     * @return
     */
    public static int[] trackGetMaxValue(int depth) {
        //走到了叶子节点,当前树的深度 == 物品的数量
        if (depth == quantity) {
            //更新最优解
            if (currentValue > maxValue) {
                maxValue = currentValue;
                for (int i = 0; i < hypotheticalChoice.length; i++) {
                    choice[i] = hypotheticalChoice[i];
                }
            }
        } else {
            //遍历当前节点（物品）的子节点：0 不放入背包 1：放入背包
            for (int i = 0; i < 2; i++) {
                hypotheticalChoice[depth] = i;
                if (i == 0) {
                    //不放入背包，向下深入
                    trackGetMaxValue(depth + 1);
                } else {
                    //放入背包
                    //约束条件，如果小于背包容量
                    if (currentWeight + weight[depth] <= capacity) {
                        //更新当前重量和价值
                        currentWeight += weight[depth];
                        currentValue += value[depth];
                        //继续向下深入,深度优先
                        trackGetMaxValue(depth + 1);
                        // 当从上一行代码 maxValue 出来后，需要回溯容量和值
                        currentWeight -= weight[depth];
                        currentValue -= value[depth];
                    }
                }
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入背包的容量：");
        capacity = scanner.nextInt();
        System.out.println("请输入物品的数量：");
        quantity = scanner.nextInt();
        System.out.println("请输入物品的重量：");
        weight = input(quantity);
        System.out.println("请输入物品的价值：");
        value = input(quantity);
        hypotheticalChoice = new int[quantity];
        choice = new int[quantity];

        trackGetMaxValue(0);

        System.out.println();
        System.out.print("当背包容量为" + capacity + "时能装物品的最大价值为：");
        System.out.println(maxValue);
        output(choice);
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
     * @param choice 数组
     * @return true Or false
     */
    public static boolean output(int[] choice) {
        if (choice == null) {
            return false;
        }
        System.out.print("最佳选择为：[");
        for (int i = 0; i < choice.length; i++) {
            if (i == choice.length - 1) {
                System.out.print(choice[i] + "]");
            } else {
                System.out.print(choice[i] + ",");
            }
        }
        return true;
    }
}
