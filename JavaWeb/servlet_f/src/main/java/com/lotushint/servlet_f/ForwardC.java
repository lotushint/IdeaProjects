package com.lotushint.servlet_f; /**
 * @package ${PACKAGE_NAME}
 * @author hefan
 * @date 2021/10/20 17:21
 * @description ${DESCRIPTION}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了ForwardC程序");
        request.getRequestDispatcher("/a/b/c.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
