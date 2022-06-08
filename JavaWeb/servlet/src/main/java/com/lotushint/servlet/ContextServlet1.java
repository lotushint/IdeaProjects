package com.lotushint.servlet; /**
 * @package ${PACKAGE_NAME}
 * @author hefan
 * @date 2021/10/17 6:18
 * @description ${DESCRIPTION}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        context.setAttribute("key1", "value1");

        System.out.println("Context1 中获取域数据key1的值是:"+ context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
