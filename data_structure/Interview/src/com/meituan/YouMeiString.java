package com.meituan;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/24 10:42
 * @package com.meituan
 * @description 第2组 小美的优美字符串
 */
public class YouMeiString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int result = getSubstringNums(string);
        System.out.println(result);
    }

    private static int getSubstringNums(String string) {
        int length = string.length();
        int result = 1;
        int[] nums = new int[122];
        //每种字符对应的子字符串种数，如 a 有三种即 “”,“a”,“a”; b有两种即 ”“,“b”; c有两种 ”“,“c”
        for (int i = 0; i < length; i++) {
            nums[string.charAt(i)]++;
        }
        //排列组合方式
        for (int j = 0; j < 122; j++) {
            if (nums[j] != 0) {
                //加一别忘空串
                result *= nums[j] + 1;
            }
        }

        return result;
    }
}
