package com.lotushint.study.chapter04.one_7;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/3/23 17:00
 * @package com.lotushint.study.chapter04.one_7
 * @description 下划线
 * 下面是合理使用的规则：
 * 1.仅限单 _，不能多条相连。
 * 2.数值开头和结尾不允许出现 _。
 * 3.F、D 和 L的前后禁止出现 _。
 * 4.二进制前导 b 和 十六进制 x 前后禁止出现 _。
 *
 *
 * [1] 注意 %n的使用。熟悉 C 风格的程序员可能习惯于看到 \n 来表示换行符。问题在于它给你的是一个“Unix风格”的换行符。
 * 此外，如果我们使用的是 Windows，则必须指定 \r\n。这种差异的包袱应该由编程语言来解决。
 * 这就是 Java 用 %n 实现的可以忽略平台间差异而生成适当的换行符，但只有当你使用 System.out.printf() 或 System.out.format() 时。
 * 对于 System.out.println()，我们仍然必须使用 \n；如果你使用 %n，println() 只会输出 %n 而不是换行符。
 */
public class Underscores {
    public static void main(String[] args) {
        double d = 341_435_936.445_667;
        System.out.println(d);

        int bin = 0b0010_1111_1010_1111_1010_1111_1010_1111;
        System.out.println(Integer.toBinaryString(bin));
        System.out.printf("%x%n", bin); // [1]

        long hex = 0x7f_e9_b7_aa;
        System.out.printf("%x%n", hex);
    }
}
