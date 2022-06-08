package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author hefan
 * @time 2001.11.04
 * @description 求first集
 * <p>
 * 设有文法G[E]：
 * E→TE1
 * E1→ATE1|ε
 * T→FT1
 * T1→MFT1|ε
 * F→(E)|i
 * A→+|-
 * M→*|/
 */
public class GetFirst {

    /**
     * 实现了可变长度文法接收，在这存放的是拆分后最简单的文法，也是由用户输入
     */
    public ArrayList<String[]> in = new ArrayList<String[]>();
    /**
     * 包括左推导符和其First集
     */
    public ArrayList<String[]> first = new ArrayList<String[]>();
    /**
     * track由一条一条的非终结符串组成的路径数组
     */
    public ArrayList<String[]> track = new ArrayList<String[]>();

    public GetFirst() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请分行输入一个完整文法:(end结束)");
        String sline = "";
        sline = sc.nextLine();
        while (!sline.startsWith("end")) {
            StringBuffer buffer = new StringBuffer(sline);
            int l = buffer.indexOf(" ");
            while (l >= 0) {//去空格
                buffer.delete(l, l + 1);
                l = buffer.indexOf(" ");
            }
            sline = buffer.toString();
            String s[] = sline.split("->");//左推导符
            if (s.length == 1) {
                s = sline.split("→");//考虑到输入习惯和形式问题
            }
            if (s.length == 1) {
                s = sline.split("=>");
            }
            if (s.length == 1) {
                System.out.println("文法有误");
                System.exit(0);
            }
            StringTokenizer fx = new StringTokenizer(s[1], "|︱");//按英文隔符拆开产生式或按中文隔符拆开
            while (fx.hasMoreTokens()) {
                String[] one = new String[2];//对于一个语句只需保存两个数据就可以了，语句左部和语句右部的一个简单导出式，假如有或符，就按多条存放
                one[0] = s[0];//头不变,0位置放非终结符
                one[1] = fx.nextToken();//1位置放导出的产生式，就是产生式右部的一个最简单导出式
                in.add(one);
            }
            sline = sc.nextLine();
        }
        //求First集过程
        this.process();
        /*
         * 打印First集算法和First集
         */
        System.out.println("First集算法：");
        this.print(track);//打印First集算法
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
        track.clear();//因为下面还要用，这里就先清空了
    }

//    public void PrintArrayList(ArrayList<String[]> arrayList) {
//        for (int i = 0; i < arrayList.size(); i++) {
//            String[] r = arrayList.get(i);
//            System.out.println(r[0] + "->" + r[1]);
//        }
//    }

    public ArrayList<String> getFirst(String s, String track1) {//s表示左推导，track表示寻找路径，避免循环查找
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> result1 = new ArrayList<String>();
        if (Character.isUpperCase(s.charAt(0))) {//如果是非终结符，大写
            for (int i = 0; i < in.size(); i++) {
                String[] one = in.get(i);
                if (s.equals(one[0])) {
                    if (track1.substring(0, track1.length() - 9).indexOf("First(" + s + ")") >= 0)//假如在查找过程嵌套了这步，证明进入了无限循环，不需再找，此路径无结果
                    {
                        ;//有点要注意一下，本来一开始就把第一个开始推导符的First路径放进去了的，所以要避开这一次，不然已开始就结束了
                    } else if (one[1].length() == 1 || one[1].charAt(1) != '\'' && one[1].charAt(1) != '’') {
                        result1 = getFirst(one[1].charAt(0) + "", track1 + "First(" + one[1].charAt(0) + ")/");
                    } else if (one[1].length() > 1 && one[1].charAt(1) == '\'' || one[1].charAt(1) == '’')//假如接下来一个要求First的非终结符带了一撇，那一撇包括英文表示和中文表示
                    {
                        result1 = this.getFirst(one[1].substring(0, 2), track1 + "First(" + one[1].substring(0, 2) + ")/");
                    }
                    result = addArrayString(result, result1);
                    result1.clear();
                }
            }
        } else {//如果产生式首字符是终结字符
            if (s.equals("ε"))//注意：表示空的字符只能是这种了，其他形式在这个编译器中不能通过，还请原谅
            {
                result1.add("#");
            } else {
                result1.add(s);
            }
            result1.add(track1);//为了方便，把路径也加入了结果集，不然可能路径不匹配，没办法，因为中间有删去重复项
            result = result1;
        }
        return result;
    }

    public void process() {
        for (int i = 0; i < in.size(); i++) {
            boolean bool = true;
            for (int j = 0; j < i; j++) {
                if (in.get(j)[0].equals(in.get(i)[0])) {
                    bool = false;
                }
            }
            if (bool) {
                ArrayList<String> a = null;

                a = this.getFirst(in.get(i)[0], "First(" + in.get(i)[0] + ")/");

                String[] sf = new String[a.size() / 2 + 1];
                String[] st = new String[a.size() / 2];
                sf[0] = in.get(i)[0];
                for (int j = 0; j < a.size(); j++) {
                    if (j % 2 == 0) {
                        sf[j / 2 + 1] = a.get(j);
                    } else {
                        st[j / 2] = a.get(j);
                    }
                }

                first.add(sf);//first集

                track.add(st);//对应上面求得集的路径，在开始保存该非终结符了，因为已保存了该字符的First表示法
            }
        }
    }

    public ArrayList<String> addArrayString(ArrayList<String> a, ArrayList<String> b) {//两个字符串数组相加
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < a.size(); i += 2) {//因为这每一个结果，都保存了两个数据，第一个是结果，第二个位置保存的是得到这结果的路径
            String s = a.get(i);
            if (result.contains(s) || s.equals("")) {//如果结果集包含了这个字符串，就不加入结果集了，就是为了去掉重复项
                int index = result.indexOf(s);
                if (result.get(index + 1).length() > a.get(i + 1).length()) {//如果新来的路径比现有的短
                    result.set(index, s);
                    result.set(index + 1, a.get(i + 1));
                }
                continue;
            }
            result.add(s);
            result.add(a.get(i + 1));//还是要把路径继续保存在新的结果集中
        }
        for (int i = 0; i < b.size(); i += 2) {
            String s = b.get(i);
            if (result.contains(s) || s.equals("")) {
                int index = result.indexOf(s);
                if (result.get(index + 1).length() > b.get(i + 1).length()) {//如果新来的路径比现有的短
                    result.set(index, s);
                    result.set(index + 1, b.get(i + 1));
                }
                continue;
            }
            result.add(s);//偶数地址存放的是数据
            result.add(b.get(i + 1));//奇数地址存放的是该数据获得的路径
        }
        return result;
    }

    public void print(ArrayList<String[]> list) {
        for (int i = 0; i < list.size(); i++) {//循环非终结符个数次数
            String[] one = list.get(i);//得到某一个非终结符运行的所有路径
            String[][] Strings = new String[one.length][];
            String[] finals = new String[one.length];//路径最终站点
            int number = 0;//记录某一步最终有效站点个数，本来有几条路径，就因该有几个有效站点，但可能有些站点有重复的，即从同一站点发出
            int max = 0;
            for (int j = 0; j < one.length; j++) {
                Strings[j] = one[j].split("/");
                if (Strings[j].length > max) {
                    max = Strings[j].length;//求得某一非终结符路径最长一条
                }
            }
            for (int j = 0; j < max; j++) {//循环最长站点次数
                number = 0;
                for (int k = 0; k < Strings.length; k++) {//有多少条路径就循环多少次
                    String lsh = "";
                    if (j >= Strings[k].length) {
                        lsh = Strings[k][Strings[k].length - 1];
                    } else {
                        lsh = Strings[k][j];
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
                for (int k = 0; k < number; k++) {//打印每一条路径的某个站点
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

    public static void main(String[] args) {
        GetFirst getFirst = new GetFirst();
    }
}
