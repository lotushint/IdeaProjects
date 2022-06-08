package com.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/25 10:29
 * @package com.meituan
 * @description 第14组 寻找数字
 */
public class FindNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        findNumber(s);
    }

    static void findNumber(String s) {
        String str = "";
        String[] strings;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                str += s.charAt(i);
            } else {
                str += ",";
            }
        }
        strings = str.split(",");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            //将我们的字符串转换成Int类型
            if (!strings[i].equals("")) {
                array[i] = Integer.parseInt(strings[i]);
            }

        }
        Arrays.sort(array);
        for (int a : array) {
            if (a != 0) {
                System.out.println(a);
            }
        }
    }
}
