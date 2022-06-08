package com.lotushint.BigIntegerMultiplication;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/16 14:47
 * @package com.lotushint.BigIntegerMultiplication
 * @description 大整数乘法（2进制）
 */
public class BigIntegerMultiplication {
    public static void main(String[] args) {
        long x;
        long y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 2 个二进制数: ");
//        String sx = scanner.nextLine();
//        String sy = scanner.nextLine();
//        x = Integer.parseInt(sx, 2);
//        y = Integer.parseInt(sx, 2);
        x = scanner.nextLong(2);
        y = scanner.nextLong(2);
        String sx = String.valueOf(x);
        int n = sx.length();
        double s = bigIntegerMultiplication(x, y, n);
        System.out.println(x + " * " + y + " = " + s);
    }

    /**
     * 计算两个数的乘积
     *
     * @param x 乘数
     * @param y 乘数
     * @param n 乘数的长度
     * @return
     */
    public static double bigIntegerMultiplication(long x, long y, int n) {
        if (n == 1) {
            return x * y;
        } else {
            //对奇数的操作
            if (n % 2 == 1) {
                n = n - 1;
            }
            long A = x / Math.round(Math.pow(2, (n / 2)));
            long B = x - A * Math.round(Math.pow(2, (n / 2)));
            long C = y / Math.round(Math.pow(2, (n / 2)));
            long D = y - C * Math.round(Math.pow(2, (n / 2)));

            /*
            计算A*C,B*D
             */
            double AMC = bigIntegerMultiplication(A, C, n / 2);
            double BMD = bigIntegerMultiplication(B, D, n / 2);

            /*
            计算A+B,C+D
             */
            long AAB = A + B;
            long CAD = C + D;

            /**
             * 计算（A-B)(D-C)
             */
            double AsB_m_DsC = bigIntegerMultiplication(AAB, CAD, n / 2);

            return (AMC * Math.pow(2, n) + (AsB_m_DsC - AMC - BMD) * Math.pow(2, n / 2) + BMD);
        }
    }
}
