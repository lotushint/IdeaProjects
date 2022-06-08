import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author lotushint
 * @package PACKAGE_NAME
 * @date 2021/12/15 下午8:07
 * @description
 */
public class IntermediateCode extends JFrame {
    private JTextArea jTextArea = new JTextArea();
    private JButton jButton = new JButton("选择翻译的文件");
    private JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        new IntermediateCode();
    }

    public IntermediateCode() {
        setLayout(new BorderLayout());
        jPanel.add(jButton);
        add(jPanel, BorderLayout.NORTH);
        add(new JScrollPane(jTextArea));

        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(new ActionListener() {     //点击按钮，把文件内容翻译为四元式
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String stringFromFile = getStringFromFile();           //从文件获取算术表达式字符串
                    String standerdString = toStanderd(stringFromFile);    //把字符串转化为合适的格式,比如：23*(78-2)变为23 * ( 78 -2 )这样的形式
                    String getString_epilogue = getepilogue(standerdString); //中序算术表达式转为后序，比如a*(b-c)转为bc-a*
                    String getSiYuanShi_string = getSiYuanShi(getString_epilogue);
                    jTextArea.append(getSiYuanShi_string);
                } catch (Exception ex) {

                }
            }
        });

    }

    public String getStringFromFile() throws Exception {     //从文件第一行获取算术表达式字符串
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();       //选择文件
        Scanner read = new Scanner(file);
        String str = read.next();                       //读取文件第一行

        return str;
    }

    /**
     * 扫描字符串
     * 扫描到操作数，直接加入另一个符号串
     * 扫描到符号，将" "+符号+" "加入另一个符号串
     * @param string
     * @return
     */
    public String toStanderd(String string) {           //把字符串转化为合适的格式,比如：23*(78-2)变为23 * ( 78 -2 )这样的形式
        String standerdString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '-' || string.charAt(i) == '+' || string.charAt(i) == '/' || string.charAt(i) == '*' || string.charAt(i) == '(' || string.charAt(i) == ')') {
                standerdString += " " + string.charAt(i) + " ";
            } else {
                standerdString += string.charAt(i);
            }
        }

        System.out.println(standerdString);

        //如果表达式里面有两个符号相连，比如：减号后面是括号，则会之间会产生两个空格，下面代码则把两个空格变为一个空格
        String[] str = standerdString.split("  "); //这里是两个空格
        standerdString = "";                //将之前的字符串清空
        for (int i = 0; i < str.length; i++) {
            standerdString += str[i] + " ";
        }

        System.out.println(standerdString);

        return standerdString;
    }


    /**
     *
     * @param string
     * @return
     */
    public String getepilogue(String string) {              //中序算术表达式转为后序，比如a*(b-c)转为bc-a*
        String[] string_array = string.split(" ");    //扫描字符串数组，用两个栈来处理，扫描到操作数压入操作数栈，扫描到符号，压入符号栈
        Stack<String> stack_operand = new Stack<>();         //操作数栈
        Stack<String> stack_symbol = new Stack<>();          //符号栈

        for (int i = 0; i < string_array.length; i++) {
            if (string_array[i].equals("+") || string_array[i].equals("-") || string_array[i].equals("*") || string_array[i].equals("/") || string_array[i].equals("(") || string_array[i].equals(")")) {
                if (stack_symbol.isEmpty()) {                        //(2)
                    stack_symbol.push(string_array[i]);
                } else if (string_array[i].equals("(")) {              //(3)
                    stack_symbol.push(string_array[i]);
                } else if (stack_symbol.peek().equals("(")) {
                    stack_symbol.push(string_array[i]);            //(4)
                } else if (string_array[i].equals(")")) {              //(5)
                    while (true) {
                        String symbol = stack_symbol.pop();
                        if (symbol.equals("(")) {
                            break;
                        } else {
                            stack_operand.push(symbol);
                        }
                    }
                }
                /*下面的else if和else为规则(6)*/
                else if ((stack_symbol.peek().equals("+") || stack_symbol.peek().equals("-")) && (string_array[i].equals("*") || string_array[i].equals("/"))) {
                    stack_symbol.push(string_array[i]);
                } else {
                    stack_operand.push(stack_symbol.pop());
                    stack_symbol.push(string_array[i]);
                }
            } else {
                stack_operand.push(string_array[i]);               //(1)
            }
        }

        /*下面while循环用规则(7)*/
        while (true) {
            if (stack_symbol.isEmpty()) {
                break;
            } else {
                stack_operand.push(stack_symbol.pop());
            }
        }

        String string_epilogue = "";
        for (String str : stack_operand) {           //把后序表达式栈转为后序字符串
            string_epilogue += str + " ";
        }

        System.out.println(string_epilogue);

        return string_epilogue;
    }

    /*扫描后序算术表达式；
     * 扫描到操作数直接压入栈       - - - -(1)
     * 扫描到"+"，"-"，"*"，"/"，将栈的栈顶的两个操作数压出，压出的两个操作数和扫描到的符号组合成四元式，再将结果压入栈    - - - -(2)
     * */
    public String getSiYuanShi(String string) {
        String SiYuanShiString = "";
        String[] string_array = string.split(" ");
        Stack<String> stack = new Stack<>();
        int result_num = 0;
        String result = "T";
        for (int i = 0; i < string_array.length; i++) {      //开始扫描字符串数组
            if (string_array[i].equals("+") || string_array[i].equals("-") || string_array[i].equals("*") || string_array[i].equals("/")) {
                result_num++;
                result += result_num;
                SiYuanShiString += "(" + string_array[i] + "," + stack.pop() + "," + stack.pop() + "," + result + ")\n";
                stack.push(result);
                result = "T";
            } else {
                stack.push(string_array[i]);
            }
        }

        return SiYuanShiString;
    }
}