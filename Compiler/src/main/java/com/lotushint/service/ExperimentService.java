package com.lotushint.service;

import com.lotushint.pojo.First;
import com.lotushint.pojo.Lex;

/**
 * @author hefan
 * @package com.lotushint.service
 * @date 2021/11/18 12:24
 * @description 所有实验
 */
public interface ExperimentService {

    /**
     * 1.DFA的识别程序
     */
    public void identificationProcedureOfDFA();

    /**
     * 2.词法分析程序的实现
     */
    public Lex lexicalAnalysisProgram(String text);

    /**
     * 3.FirstFollow集的实现
     */
    public First firstSet(String text);

    /**
     * 4.LL(1)语法分析程序的实现
     */
    public void llSyntaxAnalyzer();

    /**
     * 5.递归下降语法分析方法的实现
     */
    public void recursiveDescentParsingMethod();

    /**
     * 6.SLR(1)语法分析程序的实现
     */
    public void slrSyntaxAnalyzer();

    /**
     * 7.标识符的语法分析
     */
    public void syntaxAnalysisOfIdentifiers();

    /**
     * 8.算术表达式四元式中间代码生成
     */
    public void intermediateCodeGeneration();
}
