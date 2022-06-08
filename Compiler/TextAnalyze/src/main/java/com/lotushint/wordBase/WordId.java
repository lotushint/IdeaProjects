package com.lotushint.wordBase;

/**
 * 单词类别赋值
 * @author hefan
 * @date 2021.11.25
 */
public class WordId {
    public final static int
            //保留字
            BEGIN = 1,
            END = 2,
            INTEGER = 3,
            FUNCTION = 4,
            READ = 5,
            WRITE = 6,
            IF = 7,
            THEN = 8,
            ELSE = 9,
    //标识符
    SYMBOL = 11,

    //常数
    CONSTANT = 12,

    //运算符 "+"
    ADD = 13,
    //运算符 "-"
    SUB = 14,
    //运算符 "*"
    MUL = 15,
    //运算符 "/"
    DIV = 16,
    //运算符 "<="
    LT = 18,
    //运算符 ">="
    GT = 19,
    //运算符 "!="
    UNEQUAL_SIGN = 20,
    //运算符 "="
    ASSIGNMENT = 23,

    //界符 "("
    LEFT_PARENTHESIS = 24,
    //界符 ")"
    RIGHT_PARENTHESIS = 25,
    //界符 ";"
    SEMICOLON = 26,

    //行尾符
    LINE_END = 27,

    //结尾符 "#"
    ALL_END = 28;
}