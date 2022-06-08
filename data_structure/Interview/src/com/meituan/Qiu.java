package com.meituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/28 10:42
 * @package com.meituan
 * @description
 */
public class Qiu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] result = new int[n];
        int[] yinShu = new int[n];
        for (int i = 0; i < n; i++) {
            yinShu[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            HashSet set = new HashSet();
            for (int j = 0; j < n; j++) {
                //排除自己
                if (j != i) {
                    Integer k = yinShu[i] % yinShu[j];
                    boolean contains = false;
                    if (!set.isEmpty()) {
                        contains = set.contains(k);
                    }
                    if (contains == false) {
                        set.add(k);
                        result[i]++;
                    }
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }

    }
}
