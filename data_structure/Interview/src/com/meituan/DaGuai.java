package com.meituan;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/28 10:16
 * @package com.meituan
 * @description
 */
public class DaGuai {
    /**
     * 攻击力，初始为1
     */
    static int attack = 1;

    public static void main(String[] args) {
        int min;
        int huiHe = 0;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] blood = new int[num];
        int[] flag = new int[num];
        for (int i = 0; i < num; i++) {
            blood[i] = scanner.nextInt();
        }


        while (true) {
            //找到最小怪
            int i;
            int m = 0;
            min = Integer.MAX_VALUE;
            for (i = 0; i < num; i++) {
                if (blood[i] < min && flag[i] == 0) {
                    min = blood[i];
                    m = i;
                }
            }
            flag[m] = 1;
            huiHe += min / attack;
            attack++;
            if (attack >= num + 1) {
                System.out.println(huiHe);
                break;
            }
        }
    }
}
