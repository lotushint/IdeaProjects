package com.lotushint.ImplementationOfLexicalAnalysisProgram.word;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.WordId;

/**
 * 行尾符
 * @author hefan
 * @date 2021.11.25
 */
public class LineEnd extends BaseToken {

    /**
     *
     * @param word 单词
     */
    public LineEnd(String word) {
        super(WordId.LINE_END);
        this.word = word;
        this.name = "行尾符";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final LineEnd lineEnd = new LineEnd("\r\n");
}