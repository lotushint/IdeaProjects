package com.lotushint;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/6/2 12:23
 * @package com.lotushint
 * @description 0-1 背包问题（分支限界法）
 */
public class KnapsackBranchBoundary {
    public static void main(String[] args) {
        Knapsack[] bags = new Knapsack[]{
                new Knapsack(2, 13), new Knapsack(1, 10),
                new Knapsack(3, 24), new Knapsack(2, 15),
                new Knapsack(4, 28), new Knapsack(5, 33),
                new Knapsack(3, 20), new Knapsack(1, 8)
        };
        int totalWeight = 12;
        BranchLimitProblem problem = new BranchLimitProblem(bags, totalWeight);

        problem.solve();
        System.out.println(problem.getBestValue());
    }
}

class Knapsack implements Comparable<Knapsack> {
    /**
     * 物品重量
     */
    private int weight;
    /**
     * 物品价值
     */
    private int value;
    /**
     * 单位重量价值
     */
    private int unitValue;

    public Knapsack(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.unitValue = (weight == 0) ? 0 : value / weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getUnitValue() {
        return unitValue;
    }

    @Override
    public int compareTo(Knapsack knapsack) {
        int value = knapsack.unitValue;
        if (unitValue > value) {
            return 1;
        }
        if (unitValue < value) {
            return -1;
        }
        return 0;
    }

}

class BranchLimitProblem {

    /**
     * 准备放入背包中的物品
     */
    private Knapsack[] bags;
    /**
     * 背包的总承重
     */
    private int totalWeight;
    /**
     * 给定的物品数
     */
    private int n;
    /**
     * 物品放入背包可以获得的最大价值
     */
    private int bestValue;

    public BranchLimitProblem(Knapsack[] bags, int totalWeight) {
        super();
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;
        //物品依据单位重量价值进行排序
        Arrays.sort(bags, Collections.reverseOrder());
    }

    /**
     * 队列式分支限界法
     */
    public void solve() {
        LinkedList<Node> nodeList = new LinkedList<>();

        //起始节点当前重量和当期价值均为 0
        nodeList.add(new Node(0, 0, 0));

        while (!nodeList.isEmpty()) {
            // 取出放入队列中的第一个节点
            Node node = nodeList.pop();

            if (node.upperLimitValue >= bestValue && node.index < n) {
                // 左节点：该节点代表物品放入背包中，上个节点的价值+本次物品的价值为当前价值
                int leftWeight = node.currWeight + bags[node.index].getWeight();
                int leftValue = node.currValue + bags[node.index].getValue();
                Node left = new Node(leftWeight, leftValue, node.index + 1);

                // 放入当前物品后可以获得的价值上限
                left.upperLimitValue = getUpperLimitValue(left);

                // 当物品放入背包中左节点的判断条件为保证不超过背包的总承重
                if (left.currWeight <= totalWeight && left.upperLimitValue > bestValue) {
                    // 将左节点添加到队列中
                    nodeList.add(left);
                    if (left.currValue > bestValue) {
                        // 物品放入背包不超重，且当前价值更大，则当前价值为最大价值
                        bestValue = left.currValue;
                    }
                }

                // 右节点：该节点表示物品不放入背包中，上个节点的价值为当前价值
                Node right = new Node(node.currWeight, node.currValue,
                        node.index + 1);

                // 不放入当前物品后可以获得的价值上限
                right.upperLimitValue = getUpperLimitValue(right);

                if (right.upperLimitValue >= bestValue) {
                    // 将右节点添加到队列中
                    nodeList.add(right);
                }
            }
        }
    }

    /**
     * 当前操作的节点，放入物品或不放入物品
     */
    class Node {
        /**
         * 当前放入物品的重量
         */
        private int currWeight;
        /**
         * 当前放入物品的价值
         */
        private int currValue;
        /**
         * 不放入当前物品可能得到的价值上限
         */
        private int upperLimitValue;
        /**
         * 当前操作的索引
         */
        private int index;

        public Node(int currWeight, int currValue, int index) {
            this.currWeight = currWeight;
            this.currValue = currValue;
            this.index = index;
        }
    }

    /**
     * 价值上限 = 节点现有价值 + 背包剩余容量 * 剩余物品的最大单位重量价值 <br>
     * 当物品由单位重量的价值从大到小排列时，计算出的价值上限大于所有物品的总重量，否则小于物品的总重量 <br>
     * 当放入背包的物品越来越来越多时，价值上限也越来越接近物品的真实总价值 <br>
     *
     * @param node
     * @return
     */
    private int getUpperLimitValue(Node node) {

        /**
         * 获取背包剩余容量
         */
        int remainingCapacityWeight = totalWeight - node.currWeight;
        int value = node.currValue;
        /**
         * 结点索引
         */
        int i = node.index;

        while (i < this.n && bags[i].getWeight() <= remainingCapacityWeight) {
            remainingCapacityWeight -= bags[i].getWeight();
            value += bags[i].getValue();
            i++;
        }

        // 当物品超重无法放入背包中时，可以通过背包剩余容量 * 下个物品单位重量的价值计算出物品的价值上限
        if (i < this.n) {
            value += bags[i].getUnitValue() * remainingCapacityWeight;
        }

        return value;
    }

    public int getBestValue() {
        return bestValue;
    }
}