package com.lotushint;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/8 18:42
 * @package com.lotushint
 * @description 幂集
 */
public class PowerSet {
    public static void main(String[] args) {
        System.out.println("请输入一个集合{a,b,c...}:");
        Scanner scanner = new Scanner(System.in);
        String setStr = scanner.next();
        String substring = setStr.substring(1, setStr.length() - 1);
        /**
         * 集合里的元素
         */
        String[] str = substring.split(",");
        /**
         * 存放临时数据
         */
        Set<String> setTemp = new HashSet<String>();
        /**
         * 存放最终需要的数据
         */
        Set<String> setResult = new HashSet<String>();

        setTemp.add(str[0]);
        for (int i = 1; i < str.length; i++) {
            setResult.add(str[i]);
            for (String s : setTemp) {
                setResult.add(s);
                setResult.add(s + "," + str[i]);
            }
            setTemp.addAll(setResult);
        }
        System.out.print("{");
        Iterator it = setResult.iterator();
        while (it.hasNext()) {
            String v = (String) it.next();
            System.out.print("{" + v + "}" + ",");
        }
        System.out.print("Ø}");
    }
}
