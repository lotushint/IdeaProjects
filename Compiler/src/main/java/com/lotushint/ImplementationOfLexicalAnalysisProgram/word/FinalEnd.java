package com.lotushint.ImplementationOfLexicalAnalysisProgram.word;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.BaseToken;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.wordBase.WordId;

/**
 * 结尾符
 *
 * @author hefan
 * @date 2021.11.25
 */
public class FinalEnd extends BaseToken {

    /**
     * @param word 单词
     */
    public FinalEnd(String word) {
        super(WordId.ALL_END);
        this.word = word;
        this.name = "结尾符";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final FinalEnd allEnd = new FinalEnd("#");
}