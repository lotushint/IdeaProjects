package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/7 14:14
 * @package com.lotushint
 * @description 汉诺塔问题
 */
public class Hanoi {
    /**
     * 总移动次数
     */
    static int m = 0;

    /**
     * 实现移动的函数
     *
     * @param id 正在移动的圆盘号
     * @param N  正在移动的圆盘目前的位置
     * @param M  正在移动的圆盘将要移动的目的地
     */
    public static void move(int id, char N, char M) {
        System.out.println("第 " + (++m) + " 次移动 : " + " 把 " + id + " 号圆盘从 " + N + " 移到  " + M);
    }

    /**
     * 递归实现汉诺塔的函数
     *
     * @param n 圆盘数
     * @param A 起始塔
     * @param B 辅助塔
     * @param C 终点塔
     */
    public static void hanoi(int n, char A, char B, char C) {
        // 圆盘只有一个时，只需将其从A塔移到C塔
        if (n == 1) {
            // 将编号为1的圆盘从A移到C
            Hanoi.move(1, A, C);
        } else {
            // 递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            hanoi(n - 1, A, C, B);
            // 把A塔上编号为n的圆盘移到C上
            Hanoi.move(n, A, C);
            // 递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
            hanoi(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去）");
        System.out.print("请输入圆盘的个数：");
        int n = sc.nextInt();
        Hanoi.hanoi(n, 'A', 'B', 'C');
        System.out.println("共移动了" + m + "次，把A上的圆盘都移动到了C上");
        sc.close();
    }

}
