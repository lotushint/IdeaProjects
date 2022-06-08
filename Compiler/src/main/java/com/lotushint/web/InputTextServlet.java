package com.lotushint.web;

import com.lotushint.pojo.First;
import com.lotushint.service.ExperimentService;
import com.lotushint.service.serviceImpl.ExperimentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lotushint
 * @package com.lotushint.web
 * @date 2021/11/15 3:46
 * @description 文本处理映射
 */
@WebServlet(name = "inputTextServlet", value = "/inputTextServlet")
public class InputTextServlet extends HttpServlet {

    private final ExperimentService experimentService = new ExperimentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入的文法(text_input.html)
        String text = request.getParameter("textInput");
        First first = experimentService.firstSet(text);
//        response.setCharacterEncoding("utf-8");
//        Gson gson = new Gson();
//        response.getWriter().print(gson.toJson(list));

        request.setAttribute("text", text);
        request.setAttribute("data", first.data);
        request.setAttribute("track", first.track);
        request.getRequestDispatcher("templates/first_follow_resolved.jsp").forward(request, response);
//        response.getWriter().write(data);
    }
}
