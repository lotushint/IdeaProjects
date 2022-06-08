package com.lotushint.servlet_f;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class RequestAPIServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        i.getRequestURI()					获取请求的资源路径
        System.out.println("URI => " + request.getRequestURI());
//        ii.getRequestURL()					获取请求的统一资源定位符（绝对路径）
        System.out.println("URL => " + request.getRequestURL());
//        iii.getRemoteHost()				获取客户端的ip地址
        /**
         * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("customer ip => " + request.getRemoteHost());
//        iv.getHeader()						获取请求头
        System.out.println("RequestHead User-Agent ==>> " + request.getHeader("User-Agent"));
//        vii.getMethod()					获取请求的方式GET或POST
        System.out.println( "RequestMethod ==>> " + request.getMethod() );
    }

    @Override
    public void destroy() {
    }
}