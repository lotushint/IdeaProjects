package com.lotushint.word;

import com.lotushint.wordBase.BaseToken;
import com.lotushint.wordBase.WordId;

/**
 * 常数
 * @author hefan
 * @date 2021.11.25
 */
public class ConstantNum extends BaseToken {
    public final int value;

    /**
     *
     * @param value 常数值
     */
    public ConstantNum(int value) {
        super(WordId.CONSTANT);
        this.value = value;
        this.name = "常数";
    }

    @Override
    public String toString() {
        return "" + value;
    }
}