package com.lotushint.ImplementationOfFirstSet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
设有文法G[E]：
  E→TE1
  E1→ATE1|ε
  T→FT1
  T1→MFT1|ε
  F→(E)|i
  A→+|-
  M→*|/
 */

/**
 * @author lotushint
 * @package com.lotushint.ImplementationOfFirstSet
 * @date 2021/11/5 0:59
 * @description 求first集和first集算法并格式化打印源
 */
public class GetFirst {

    /**
     * 保存拆分后的所有产生式，如A->a|ab|c拆分成A->a,A->ab,A->c
     */
    public ArrayList<String[]> in = new ArrayList<String[]>();
    /**
     * 包括非终结符和其First集
     */
    public ArrayList<String[]> first = new ArrayList<String[]>();
    /**
     * track由一条一条的非终结符串组成的路径数组
     */
    public ArrayList<String[]> track = new ArrayList<String[]>();

    public GetFirst() {

    }

    /**
     * 对输入文法处理 first集和first算法
     *
     * @param text
     * @return
     * @throws IOException
     */
    public List<String[]> first(String text) throws IOException {
        /**
         * 临时保存一行文法
         */
        String sline = "";
        BufferedReader textBuffer = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        sline = textBuffer.readLine();
        while (!sline.startsWith("end")) {
            StringBuffer buffer = new StringBuffer(sline);
            int l = buffer.indexOf(" ");
            //去空格
            while (l >= 0) {
                buffer.delete(l, l + 1);
                l = buffer.indexOf(" ");
            }
            sline = buffer.toString();
            String s[] = sline.split("->");
            if (s.length == 1) {
                s = sline.split("→");
            }
            if (s.length == 1) {
                s = sline.split("=>");
            }
            if (s.length == 1) {
                System.out.println("文法有误");
                System.exit(0);
            }
            //将产生式右部按英文隔符拆开产生式或按中文隔符拆开
            StringTokenizer fx = new StringTokenizer(s[1], "|︱");
            while (fx.hasMoreTokens()) {
                //对于一个产生式只需保存两个数据就可以了，产生式左部和产生式右部的一个简单导出式，假如有或符，就按多条存放
                String[] one = new String[2];
                //头不变,0位置放非终结符
                one[0] = s[0];
                //1位置放导出的产生式，就是产生式右部的一个最简单导出式
                one[1] = fx.nextToken();
                in.add(one);
            }
            sline = textBuffer.readLine();
        }
        //求First集过程
        this.process();
        /*
         * 格式化打印First集算法track和First集first
         */
        System.out.println("First集算法：");
        this.print(track);
        //打印First集算法
        System.out.println("First集：");
        for (int i = 0; i < first.size(); i++) {
            String[] r = first.get(i);
            System.out.print("First(" + r[0] + ")={");
            for (int j = 1; j < r.length; j++) {
                System.out.print(r[j]);
                if (j < r.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
//        track.clear();//因为下面还要用，这里就先清空了
        return first;
    }

    /**
     * 格式化first集算法显示到页面的字符串
     *
     * @param list
     * @return
     */
    public String trackToString(ArrayList<String[]> list) {
        //路径最终字符串
        String trackString = "";

        //循环非终结符个数次数
        for (int i = 0; i < list.size(); i++) {
            //得到某一个非终结符运行的所有路径
            String[] one = list.get(i);
            String[][] strings = new String[one.length][];
            //路径最终站点
            String[] finals = new String[one.length];
            //记录某一步最终有效站点个数，本来有几条路径，就因该有几个有效站点，但可能有些站点有重复的，即从同一站点发出
            int number = 0;
            int max = 0;
            for (int j = 0; j < one.length; j++) {
                strings[j] = one[j].split("/");
                if (strings[j].length > max) {
                    max = strings[j].length;//求得某一非终结符路径最长一条
                }
            }
            //循环最长站点次数
            for (int j = 0; j < max; j++) {
                number = 0;
                //有多少条路径就循环多少次
                for (int k = 0; k < strings.length; k++) {
                    String lsh = "";
                    if (j >= strings[k].length) {
                        lsh = strings[k][strings[k].length - 1];
                    } else {
                        lsh = strings[k][j];
                    }
                    int m = 0;
                    for (m = 0; m < number; m++) {//记录有效站点
                        if (lsh.equals(finals[m])) {
                            break;
                        }
                    }
                    if (m == number) {
                        finals[number] = lsh;
                        number++;
                    }
                }
                //打印每一条路径的某个站点
                for (int k = 0; k < number; k++) {
                    trackString += finals[k];
                    if (k != number - 1) {
                        trackString += " + ";
                    }
                }
                if (j < max - 1) {
                    trackString += " = ";
                }
            }
            trackString += "<br>";
        }
        return trackString;
    }

    /**
     * 打印list
     * @param arrayList
     */
    public void PrintArrayList(ArrayList<String[]> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String[] r = arrayList.get(i);
            System.out.println(r[0] + "->" + r[1]);
        }
    }

    /**
     * @param s      非终结符
     * @param track1 First算法
     * @return
     */
    public ArrayList<String> getFirst(String s, String track1) {//s表示左推导，track表示寻找路径，避免循环查找
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> result1 = new ArrayList<String>();
        if (Character.isUpperCase(s.charAt(0))) {
            //如果是非终结符，大写
            for (int i = 0; i < in.size(); i++) {
                String[] one = in.get(i);
                if (s.equals(one[0])) {
                    if (track1.substring(0, track1.length() - 9).indexOf("First(" + s + ")") >= 0)                                                    //假如在查找过程嵌套了这步，证明进入了无限循环，不需再找，此路径无结果
                    {
                        ;//有点要注意一下，本来一开始就把第一个开始推导符的First路径放进去了的，所以要避开这一次，不然已开始就结束了
                    } else if (one[1].length() == 1 || one[1].charAt(1) != '\'' && one[1].charAt(1) != '’') {
                        result1 = getFirst(one[1].charAt(0) + "", track1 + "First(" + one[1].charAt(0) + ")/");
                    } else if (one[1].length() > 1 && one[1].charAt(1) == '\'' || one[1].charAt(1) == '’') {
                        //假如接下来一个要求First的非终结符带了一撇，那一撇包括英文表示和中文表示
                        result1 = this.getFirst(one[1].substring(0, 2), track1 + "First(" + one[1].substring(0, 2) + ")/");
                    }
                    result = addArrayString(result, result1);
                    result1.clear();
                }
            }
        } else {
            //如果产生式右部首字符是终结字符
            if (s.equals("ε"))//表示空的字符
            {
                result1.add("ε");
            } else {
                result1.add(s);
            }
            //为了方便，把路径也加入了结果集，不然可能路径不匹配，没办法，因为中间有删去重复项
            result1.add(track1);
            result = result1;
        }
        return result;
    }

    /**
     * 求所有非终结符的first集
     */
    public void process() {
        for (int i = 0; i < in.size(); i++) {
            boolean bool = true;
            for (int j = 0; j < i; j++) {
                if (in.get(j)[0].equals(in.get(i)[0])) {
                    //in中字符数组非终结符相等，代表前面已经计算过其first集了，不用再求
                    bool = false;
                }
            }
            if (bool) {
                ArrayList<String> a = null;

                a = this.getFirst(in.get(i)[0], "First(" + in.get(i)[0] + ")/");

                //临时first集
                String[] sf = new String[a.size() / 2 + 1];
                //临时first算法
                String[] st = new String[a.size() / 2];
                sf[0] = in.get(i)[0];
                for (int j = 0; j < a.size(); j++) {
                    if (j % 2 == 0) {
                        sf[j / 2 + 1] = a.get(j);
                    } else {
                        st[j / 2] = a.get(j);
                    }
                }
                //first集
                first.add(sf);
                //对应上面求得集的算法，在开始保存该非终结符了，因为已保存了该字符的first表示法
                track.add(st);
            }
        }
    }

    /**
     * 两个字符串数组相加
     *
     * @param a
     * @param b
     * @return
     */
    public ArrayList<String> addArrayString(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> result = new ArrayList<String>();
        //因为这每一个结果，都保存了两个数据，第一个是结果，第二个位置保存的是得到这结果的路径
        for (int i = 0; i < a.size(); i += 2) {
            String s = a.get(i);
            //如果结果集包含了这个字符串，就不加入结果集了，就是为了去掉重复项
            if (result.contains(s) || s.equals("")) {
                int index = result.indexOf(s);
                //如果新来的路径比现有的短
                if (result.get(index + 1).length() > a.get(i + 1).length()) {
                    result.set(index, s);
                    result.set(index + 1, a.get(i + 1));
                }
                continue;
            }
            result.add(s);
            //还是要把路径继续保存在新的结果集中
            result.add(a.get(i + 1));
        }
        for (int i = 0; i < b.size(); i += 2) {
            String s = b.get(i);
            if (result.contains(s) || s.equals("")) {
                int index = result.indexOf(s);
                //如果新来的路径比现有的短
                if (result.get(index + 1).length() > b.get(i + 1).length()) {
                    result.set(index, s);
                    result.set(index + 1, b.get(i + 1));
                }
                continue;
            }
            //偶数地址存放的是数据
            result.add(s);
            //奇数地址存放的是该数据获得的路径
            result.add(b.get(i + 1));
        }
        return result;
    }

    /**
     * 格式化打印
     *
     * @param list
     */
    public void print(ArrayList<String[]> list) {
        //循环非终结符个数次数
        for (int i = 0; i < list.size(); i++) {
            //得到某一个非终结符运行的所有路径
            String[] one = list.get(i);
            String[][] strings = new String[one.length][];
            //路径最终站点
            String[] finals = new String[one.length];
            //记录某一步最终有效站点个数，本来有几条路径，就因该有几个有效站点，但可能有些站点有重复的，即从同一站点发出
            int number = 0;
            int max = 0;
            for (int j = 0; j < one.length; j++) {
                strings[j] = one[j].split("/");
                if (strings[j].length > max) {
                    //求得某一非终结符路径最长一条
                    max = strings[j].length;
                }
            }
            //循环最长站点次数
            for (int j = 0; j < max; j++) {
                number = 0;
                //有多少条路径就循环多少次
                for (int k = 0; k < strings.length; k++) {
                    String lsh = "";
                    if (j >= strings[k].length) {
                        lsh = strings[k][strings[k].length - 1];
                    } else {
                        lsh = strings[k][j];
                    }
                    int m = 0;
                    //记录有效站点
                    for (m = 0; m < number; m++) {
                        if (lsh.equals(finals[m])) {
                            break;
                        }
                    }
                    if (m == number) {
                        finals[number] = lsh;
                        number++;
                    }
                }
                //打印每一条路径的某个站点
                for (int k = 0; k < number; k++) {
                    System.out.print(finals[k]);
                    if (k != number - 1) {
                        System.out.print(" + ");
                    }
                }
                if (j < max - 1) {
                    System.out.print(" = ");
                }
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) throws IOException {
//        GetFirst getFirst = new GetFirst(
//                "E→TE1\n" +
//                        "    E1→ATE1 | ε\n" +
//                        "               T→FT1\n" +
//                        "               T1→MFT1 | ε\n" +
//                        "              F→ (E) | i\n" +
//                        "               A→+ | -\n" +
//                        "                 M→*|/)\n" +
//                        "end"
//        );
//    }
}
