package com.lotushint.servlet_f; /**
 * @package ${PACKAGE_NAME}
 * @author hefan
 * @date 2021/10/21 13:57
 * @description ${DESCRIPTION}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseIOServlet", value = "/ResponseIOServlet")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println( response.getCharacterEncoding() );//默认ISO-8859-1

        // 设置服务器字符集为UTF-8
//        response.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用UTF-8字符集
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");

        // 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效!!!!!!!!!!!!!!!!!
        response.setContentType("text/html; charset=UTF-8");

        System.out.println( response.getCharacterEncoding() );

//        要求 ： 往客户端回传 字符串 数据。
        PrintWriter writer = response.getWriter();
        writer.println("servlet context!");
        writer.write("学习response!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
