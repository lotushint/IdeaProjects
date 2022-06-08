package com.lotushint.ImplementationOfLexicalAnalysisProgram.word;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.WordId;

/**
 * 标识符
 * @author hefan
 * @date 2021.11.25
 */
public class Symbol extends BaseToken {

    /**
     *
     * @param word 单词
     */
    public Symbol(String word) {
        super(WordId.SYMBOL);
        this.word = word;
        this.name = "标识符";
    }

    @Override
    public String toString() {
        return this.word;
    }

}