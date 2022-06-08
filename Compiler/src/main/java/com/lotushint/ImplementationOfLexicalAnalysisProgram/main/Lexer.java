package com.lotushint.ImplementationOfLexicalAnalysisProgram.main;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.word.*;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author lotushint
 * @package com.lotushint.ImplementationOfLexicalAnalysisProgram.main
 * @date 2021.11.5
 * @description 词法分析并输出
 */
public class Lexer {
    /**
     * 记录行号
     */
    public static int line = 1;
    /**
     * 存放最新读入的字符
     */
    char character = ' ';
    /**
     * 保留字
     */
    HashMap<String, KeyWord> keywords = new HashMap<String, KeyWord>();
    /**
     * token序列
     */
    private ArrayList<BaseToken> tokens = new ArrayList<BaseToken>();
    /**
     * 符号表
     */
    private ArrayList<Symbol> symbols = new ArrayList<Symbol>();
    /**
     * 读取文件变量
     */
    BufferedReader reader = null;
    /**
     * 是否读取到了文件的结尾
     */
    private Boolean isEnd = false;

    /**
     * 是否读取到文件的结尾
     *
     * @return
     */
    public Boolean getReaderState() {
        return this.isEnd;
    }

    /**
     * 打印tokens序列
     *
     * @throws IOException
     */
    public String printToken() throws IOException {
        String str = "";
        String strPrint = "";
        //输出单词所在位置和类别到文件
        FileWriter writer = new FileWriter("/home/dir/jetbrainsProjects/Compiler/src/main/java/com/lotushint/ImplementationOfLexicalAnalysisProgram/txt/lex.txt");
        System.out.println("词法分析结果如下：");
        while (getReaderState() == false) {
            BaseToken tok = scan();
            //格式化worId值,右对齐，不足补空格
            String sp = "&nbsp&nbsp";
            str = str + "line=" + tok.line + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp(wordId=" + (tok.wordId < 10 ? sp + tok.wordId : tok.wordId) + ",charPos=" + tok.charPos + ")&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspname=" + tok.name + ": " + tok.toString() + "<br>";
            strPrint = strPrint + "line=" + tok.line + "\t(wordId=" + tok.wordId + ",charPos=" + tok.charPos + ")\t\tname=" + tok.name + ": " + tok.toString() + "\r\n";

        }
        writer.write(strPrint);
        System.out.print(strPrint);
        writer.flush();
        return str;
    }

    /**
     * 打印符号表
     *
     * @throws IOException
     */
    public String printSymbolsTable() throws IOException {
        String desc = "";
        String writerContext = "";
        FileWriter writer = new FileWriter("/home/dir/jetbrainsProjects/Compiler/src/main/java/com/lotushint/ImplementationOfLexicalAnalysisProgram/txt/SymbolTable.txt");
        System.out.print("\r\n\r\n符号表\r\n");
        System.out.print("编号\t\t行号\t\t名称\r\n");
        writer.write("标识符表\r\n");
        writer.write("编号 " + "\t行号 " + "\t名称 \r\n");
        Iterator<Symbol> e = symbols.iterator();
        while (e.hasNext()) {
            Symbol symbol = e.next();
            writerContext = writerContext + symbol.charPos + "\t\t" + symbol.line + "\t\t" + symbol.toString() + "\r\n";
            desc = desc + symbol.charPos + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + symbol.line + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + symbol.toString() + "<br>";
        }
        System.out.print(writerContext);
        writer.write(writerContext);
        writer.flush();
        return desc;
    }

    /**
     * 打印错误
     *
     * @param tok
     * @throws IOException
     */
    public void printError(BaseToken tok) throws IOException {
        FileWriter writer = new FileWriter("/home/dir/jetbrainsProjects/Compiler/src/main/java/com/lotushint/ImplementationOfLexicalAnalysisProgram/txt/error.txt");
        System.out.print("\r\n\r\n错误词法如下：\r\n");
        writer.write("错误词法如下：\r\n");
        String str = "line " + tok.line + "\t(" + tok.wordId + "," + tok.charPos + ")\t\t"
                + tok.name + ": " + tok.toString() + "\r\n";
        writer.write(str);
    }

    /**
     * 添加保留字
     *
     * @param w 单词
     */
    void reserve(KeyWord w) {
        keywords.put(w.word, w);
    }

    public Lexer(String text) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(text));
        StringBuilder stringBuilder = new StringBuilder();
        //一行代码
        String line;
        //初始化读取文件变量
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                //\r\n
                stringBuilder.append("\r\n");
            }
            reader = new BufferedReader(new StringReader(stringBuilder.toString()));
//            reader = new BufferedReader(new FileReader("/home/dir/jetbrainsProjects/Compiler/src/main/java/com/lotushint/ImplementationOfLexicalAnalysisProgram/txt/CompileFileExample.txt"));
        } catch (IOException e) {
            System.out.print(e);
        }

        /**
         * 添加所有保留字到keywords中
         */
        this.reserve(KeyWord.begin);
        this.reserve(KeyWord.end);
        this.reserve(KeyWord.integer);
        this.reserve(KeyWord.function);
        this.reserve(KeyWord.read);
        this.reserve(KeyWord.write);
        this.reserve(KeyWord.aIf);
        this.reserve(KeyWord.aThen);
        this.reserve(KeyWord.aElse);
    }

    /**
     * 按字符读
     *
     * @throws IOException
     */
    public void readChar() throws IOException {
        character = (char) reader.read();
        if ((int) character == 0xFFFF) {
            this.isEnd = true;
        }
    }

    /**
     * 判断是否匹配
     * 当前字符是否等于下一个字符
     *
     * @param character
     * @return
     * @throws IOException
     */
    public Boolean readChar(char character) throws IOException {
        readChar();
        if (this.character != character) {
            return false;
        }

        this.character = ' ';
        return true;
    }

    /**
     * 数字的识别
     *
     * @return 字符是否是一个数字：true & false
     * @throws IOException
     */
    public Boolean isDigit() throws IOException {
        if (Character.isDigit(character)) {
            int value = 0;
            while (Character.isDigit(character)) {
                value = 10 * value + Character.digit(character, 10);
                readChar();
            }

            ConstantNum constantNum = new ConstantNum(value);
            constantNum.line = line;
            tokens.add(constantNum);
            return true;
        } else
            return false;
    }

    /**
     * 保留字、标识符的识别
     *
     * @return
     * @throws IOException
     */
    public Boolean isLetter() throws IOException {
        if (Character.isLetter(character)) {
            StringBuffer stringBuffer = new StringBuffer();

            /*
             * 首先得到整个的一个分割
             */
            while (Character.isLetterOrDigit(character)) {
                stringBuffer.append(character);
                readChar();
            }

            /**
             * 判断是保留字还是标识符
             */
            String s = stringBuffer.toString();

            //从保留字集合里取出
            KeyWord keyWord = keywords.get(s);

            /*
             * 如果是保留字的话，keyWord不应该是空的
             */
            if (keyWord != null) {
                keyWord.line = line;
                tokens.add(keyWord);
            } else {
                /**
                 * 否则就是标识符，此处多出记录标识符编号的语句
                 */
                Symbol sy = new Symbol(s);
                //用于标记已存在标识符
                Symbol mark = sy;
                Boolean isRepeat = false;
                sy.line = line;
                for (Symbol i : symbols) {
                    if (sy.toString().equals(i.toString())) {
                        mark = i;
                        isRepeat = true;
                    }
                }
                if (!isRepeat) {
                    sy.charPos = symbols.size() + 1;
                    symbols.add(sy);
                } else if (isRepeat) {
                    sy.charPos = mark.charPos;
                }
                tokens.add(sy);
            }
            return true;
        } else
            return false;
    }

    /**
     * 符号的识别
     *
     * @return
     * @throws IOException
     */
    public Boolean isSign() throws IOException {
        switch (character) {
            case '#':
                readChar();
                FinalEnd.allEnd.line = line;
                tokens.add(FinalEnd.allEnd);
                return true;
            case '\r':
                if (readChar('\n')) {
                    readChar();
                    LineEnd.lineEnd.line = line;
                    tokens.add(LineEnd.lineEnd);
                    line++;
                    return true;
                }
            case '(':
                readChar();
                Delimiter.lpar.line = line;
                tokens.add(Delimiter.lpar);
                return true;
            case ')':
                readChar();
                Delimiter.rpar.line = line;
                tokens.add(Delimiter.rpar);
                return true;
            case ';':
                readChar();
                Delimiter.sem.line = line;
                tokens.add(Delimiter.sem);
                return true;
            case '+':
                readChar();
                Operator.add.line = line;
                tokens.add(Operator.add);
                return true;
            case '-':
                readChar();
                Operator.sub.line = line;
                tokens.add(Operator.sub);
                return true;
            case '*':
                readChar();
                Operator.mul.line = line;
                tokens.add(Operator.mul);
                return true;
            case '/':
                readChar();
                Operator.div.line = line;
                tokens.add(Operator.div);
                return true;
            case '=':
                //后面不是‘=’，就是‘=’，后面是‘=’，则为‘==’
                if (!readChar('=')) {
                    readChar();
                    Operator.assign.line = line;
                    tokens.add(Operator.assign);
                    return true;
                } else{
                    readChar();
                    Operator.es.line = line;
                    tokens.add(Operator.es);
                    return true;
                }
            case '>':
                if (readChar('=')) {
                    readChar();
                    Operator.ge.line = line;
                    tokens.add(Operator.ge);
                    return true;
                }
                break;
            case '<':
                if (readChar('=')) {
                    readChar();
                    Operator.le.line = line;
                    tokens.add(Operator.le);
                    return true;
                }
                break;
            case '!':
                if (readChar('=')) {
                    readChar();
                    Operator.ues.line = line;
                    tokens.add(Operator.ues);
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 下面开始分割关键字，标识符等信息,分成一个个单词
     *
     * @return
     * @throws IOException
     */
    public BaseToken scan() throws IOException {
        BaseToken tok;
        while (character == ' ') {
            readChar();
        }
        if (isDigit() || isSign() || isLetter()) {
            tok = tokens.get(tokens.size() - 1);
        } else {
            tok = new BaseToken(character);
            printError(tok);
        }
        return tok;
    }
}
