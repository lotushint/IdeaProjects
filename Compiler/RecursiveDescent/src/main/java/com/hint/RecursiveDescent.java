package com.hint;

import java.util.Scanner;

/**
 * @author hefan
 * @package com.hint
 * @date 2021/12/14 3:19
 * @description 递归下降（非自定义版本）
 * S->aSe
 * S->B
 * B->bBe
 * B->C
 * C->cCc
 * C->d
 */
public class RecursiveDescent {
    /**
     * 要输入的字符串
     */
    public static String s = null;
    /**
     * 是否合法
     */
    public static int flag = 0;
    public static int i = 0;

    public static void C() {
        if (s.charAt(i) == 'c') {
            i++;
            C();
            if (s.charAt(i) == 'c') {
                i++;
            } else {
                flag = 1;
            }
        } else if (s.charAt(i) == 'd') {
            i++;
        } else {
            flag = 1;
        }
    }

    public static void B() {
        if (s.charAt(i) == 'b') {
            i++;
            B();
            if (s.charAt(i) == 'e') {
                i++;
            } else {
                flag = 1;
            }
        } else {
            C();
        }
    }

    public static void S() {
        if (s.charAt(i) == 'a') {
            i++;
            S();
            if (s.charAt(i) == 'e') {
                i++;
            } else {
                flag = 1;
            }
        } else {
            B();
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        if (s.charAt(0) == '#') {

        }
        S();
        if (s.charAt(i) == '#' && flag == 0) {
            System.out.println("合法");
        } else {
            System.out.println("不合法");
        }
    }
}
