package com.lotushint.web;

import com.lotushint.ImplementationOfLexicalAnalysisProgram.main.Lexer;
import com.lotushint.pojo.Lex;
import com.lotushint.service.ExperimentService;
import com.lotushint.service.serviceImpl.ExperimentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inputCodeServlet", value = "/inputCodeServlet")
public class InputCodeServlet extends HttpServlet {

    private ExperimentService experimentService = new ExperimentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //多次提交，将静态变量重置为1（第一行），防止多次提交代码后Line叠加
        Lexer.line = 1;
        //获取输入的文法(text_input.html)
        String text = request.getParameter("textInput");
        Lex lex = experimentService.lexicalAnalysisProgram(text);
        request.setAttribute("text",text);
        request.setAttribute("data",lex.data);
        request.setAttribute("table",lex.table);
        request.getRequestDispatcher("templates/lexical_analysis_resolved.jsp").forward(request, response);
    }
}
