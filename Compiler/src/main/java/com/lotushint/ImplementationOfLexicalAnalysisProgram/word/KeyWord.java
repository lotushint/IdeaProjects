package com.lotushint.ImplementationOfLexicalAnalysisProgram.word;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.WordId;

/**
 * 保留字
 * @author hefan
 * @date 2021.11.25
 */
public class KeyWord extends BaseToken {

    /**
     * 构造器
     * @param word 单词
     * @param wordId 单词id（定义在WordId.java）
     */
    public KeyWord(String word, int wordId) {
        super(wordId);
        this.word = word;
        this.name = "保留字";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final KeyWord
            begin = new KeyWord("begin", WordId.BEGIN),
            end = new KeyWord("end", WordId.END),
            integer = new KeyWord("integer", WordId.INTEGER),
            function = new KeyWord("function", WordId.FUNCTION),
            read = new KeyWord("read", WordId.READ),
            write = new KeyWord("write", WordId.WRITE),
            aIf = new KeyWord("if", WordId.IF),
            aThen = new KeyWord("then", WordId.THEN),
            aElse = new KeyWord("else", WordId.ELSE);
}