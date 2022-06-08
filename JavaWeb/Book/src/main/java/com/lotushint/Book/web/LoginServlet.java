package com.lotushint.Book.web; /**
 * @package ${PACKAGE_NAME}
 * @author hefan
 * @date 2021/10/25 19:04
 * @description ${DESCRIPTION}
 */

import com.lotushint.Book.pojo.User;
import com.lotushint.Book.service.UserService;
import com.lotushint.Book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            request.setAttribute("msg","用户名或密码错误！");
            request.setAttribute("username",username);
            //   跳回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            // 登录 成功
            //跳到成功页面login_success.html
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }
}
