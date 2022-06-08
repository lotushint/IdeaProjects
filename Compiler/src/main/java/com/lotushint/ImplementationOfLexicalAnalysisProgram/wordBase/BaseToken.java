package com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase;

/**
 * Token父类
 *
 * @author hefan
 */
public class BaseToken {
    /**
     * 单词
     */
    public String word = "";
    /**
     * 单词类别id
     */
    public final int wordId;
    /**
     * 单词类名
     */
    public String name = "";

    /**
     * 单词所在行 初始为第一行
     */
    public int line = 1;

    /**
     * 符号表中的位置
     * 变量出现的次序，为0不是变量
     */
    public int charPos = 0;

    public BaseToken(int wordId) {
        this.wordId = wordId;
    }

    public String toString() {
        return "" + (char) wordId;
    }

}