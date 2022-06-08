package com.lotushint.ImplementationOfLexicalAnalysisProgram.word;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.WordId;

/**
 * 界符
 *
 * @author hefan
 * @date 2021.11.25
 */
public class Delimiter extends BaseToken {

    /**
     * @param word   单词
     * @param wordId 单词id（定义在WordId.java）
     */
    public Delimiter(String word, int wordId) {
        super(wordId);
        this.word = word;
        this.name = "界符";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final Delimiter
            lpar = new Delimiter("(", WordId.LEFT_PARENTHESIS),
            rpar = new Delimiter(")", WordId.RIGHT_PARENTHESIS),
            sem = new Delimiter(";", WordId.SEMICOLON);
}