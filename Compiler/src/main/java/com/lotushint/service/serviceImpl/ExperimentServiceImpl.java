package com.lotushint.service.serviceImpl;

import com.lotushint.ImplementationOfFirstSet.GetFirst;
import com.lotushint.ImplementationOfLexicalAnalysisProgram.main.Lexer;
import com.lotushint.pojo.First;
import com.lotushint.pojo.Lex;
import com.lotushint.service.ExperimentService;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author lotushint
 * @package com.lotushint.service
 * @date 2021/11/1 0:59
 * @description 所有实验的实现
 */
public class ExperimentServiceImpl implements ExperimentService {
    @Override
    public void identificationProcedureOfDFA() {

    }

    @Override
    public Lex lexicalAnalysisProgram(String text) {
        Lexer lexer = new Lexer(text);
        String data = "";
        String table = "";
        try {
            data = lexer.printToken();
            table = lexer.printSymbolsTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lex lex = new Lex(data,table);
        return lex;
    }

    @Override
    public First firstSet(String text) {
        /**
         * 格式First集字符串
         */
        String data = "";
        /**
         * 格式First集算法字符串
         */
        String track = "";

        GetFirst getFirst = new GetFirst();

        List<String[]> list = null;
        try {
            list = getFirst.first(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            int j;
            data += "First(" + list.get(i)[0] + ")={";
            for (j = 1; j < list.get(i).length - 1; j++) {
                data += list.get(i)[j] + ",";
            }
//            data +=list.get(i)[j] + "}\r\n";
            data += list.get(i)[j] + "}<br>";
        }
        track = getFirst.trackToString(getFirst.track);
        First first = new First(data,track);
        return first;
    }

    @Override
    public void llSyntaxAnalyzer() {

    }

    @Override
    public void recursiveDescentParsingMethod() {

    }

    @Override
    public void slrSyntaxAnalyzer() {

    }

    @Override
    public void syntaxAnalysisOfIdentifiers() {

    }

    @Override
    public void intermediateCodeGeneration() {

    }
}
