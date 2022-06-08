package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/3 10:51
 * @package com.lotushint
 * @description Dijkstra算法
 */
public class Dijkstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入节点数和边数(空格隔开):");
        /**
         * 节点数
         */
        int n = sc.nextInt();
        /**
         * 给的边的连接个数
         */
        int m = sc.nextInt();
        /**
         * e[i][j]表示i到j的距离
         */
        int[][] e = new int[m + 1][m + 1];

        //初始化e，i 到 i的距离初始化为0，否则初始化为最大
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println("请输入v-v`的距离（输入形式为”v v` w“，如：1 2 3,表示1,2节点的距离为3）：");
        //读入数据，初始化距离
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            e[a][b] = c;
        }
        /**
         * 表示源节点到其他目标节点的距离
         */
        int[] dis = new int[n + 1];
        /**
         * 记录节点是不是已经被遍历过了
         */
        int[] marked = new int[n + 1];
        /*
        遍历节点 1，初始化节点 1 能直接到达其他节点的距离
        */
        for (int i = 1; i <= n; i++) {
            dis[i] = e[1][i];
        }
        marked[1] = 1;

        dijkstra(e, dis, marked, n);

        System.out.println("从结点 1 到其他节点的最短距离为：");
        for (int i = 1; i <= n; i++) {
            System.out.println("1~" + i + ": " + dis[i]);
        }

    }

    /**
     * dijkstra算法求单源最短路径
     *
     * @param e      两结点 v~v` 的直接距离
     * @param dis    源点到其他节点的距离
     * @param marked 节点已被遍历的标记
     * @param n      节点的数量
     */
    private static void dijkstra(int[][] e, int[] dis, int[] marked, int n) {
//        int min = Integer.MAX_VALUE;
        /**
         * 距离源节点最近且没有被标记过的节点
         */
        int mark = -1;

        //循环除了源的其他所有节点（源节点已被遍历）,该循环表示遍历次数，n-1次就够了
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            //找到距离源节点最近且没有被标记过的节点，从第二个节点开始（源节点已被遍历）
            for (int j = 2; j <= n; j++) {
                if (marked[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    mark = j;
                }
            }
            //将这个节点标记为1，表示已经遍历过了
            marked[mark] = 1;

            //进行松弛
            for (int j = 1; j <= n; j++) {
                //一定要重新赋值，否则下一轮外循环会出问题
//                min = Integer.MAX_VALUE;

                /*
                首先求出离源节点 s 最近的节点 mark，上面的for循环已经找出来了，接着判断：
                  现在已知源节点 s 到 j 的距离 dis[j]，那么对 dis[j] 与 dis[mark] + e[mark][j] 的值进行判断，
                  即 dis[j] = min(dis[j], dis[mark] + e[mark][j]);
                  如果大于，那么证明存在 s-mark-j 的距离小于 s-j 的距离，这样最短路径就可以更新出来了。
                 */
                if (e[mark][j] < Integer.MAX_VALUE) {
                    if (dis[j] > dis[mark] + e[mark][j]) {
                        dis[j] = dis[mark] + e[mark][j];
                    }
                }
            }
//            min = Integer.MAX_VALUE;
        }
    }
}