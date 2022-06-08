package com.lotushint.word;

import com.lotushint.wordBase.BaseToken;
import com.lotushint.wordBase.WordId;

/**
 * 运算符
 * @author hefan
 * @date 2021.11.25
 */
public class Operator extends BaseToken {

    /**
     *
     * @param operator 运算符
     * @param wordId 单词id（定义在WordId.java）
     */
    public Operator(String operator, int wordId) {
        super(wordId);
        this.word = operator;
        this.name = "运算符";
    }

    @Override
    public String toString() {
        return this.word;
    }

    public static final Operator
            add = new Operator("+", WordId.ADD),
            sub = new Operator("-", WordId.SUB),
            mul = new Operator("*", WordId.MUL),
            div = new Operator("/", WordId.DIV),
            le = new Operator("<=", WordId.LT),
            ge = new Operator(">=", WordId.GT),
            ne = new Operator("!=", WordId.UNEQUAL_SIGN),
            assign = new Operator("=", WordId.ASSIGNMENT);
}