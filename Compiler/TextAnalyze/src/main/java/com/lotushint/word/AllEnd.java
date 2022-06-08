package com.lotushint.word;

import com.lotushint.wordBase.BaseToken;
import com.lotushint.wordBase.WordId;

/**
 * 结尾符
 * @author hefan
 * @date 2021.11.25
 */
public class AllEnd extends BaseToken {

    /**
     *
     * @param word 单词
     */
    public AllEnd(String word) {
        super(WordId.ALL_END);
        this.word = word;
        this.name = "结尾符";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final AllEnd allEnd = new AllEnd("#");
}