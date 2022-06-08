package com.lotushint.Book.web; /**
 * @package ${PACKAGE_NAME}
 * @author hefan
 * @date 2021/11/8 20:37
 * @description ${DESCRIPTION}
 */

import com.lotushint.Book.pojo.User;
import com.lotushint.Book.service.UserService;
import com.lotushint.Book.service.impl.UserServiceImpl;
import com.lotushint.Book.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);
            //   跳回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            // 登录 成功
            //跳到成功页面login_success.html
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        Map<String,String[]> parameterMap = request.getParameterMap();
        for(Map.Entry<String,String[]> entry: parameterMap.entrySet()){
            System.out.println(entry.getKey()+" = "+ Arrays.asList(entry.getValue()));
        }
        //写成一行更加简洁    在WebUtils中用<T> T就不需要类型转换(User)了
        User user = WebUtils.copyParamToBean(request.getParameterMap(),new User());

//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("username[" + username + "]已存在!");

                //把回显信息，保存到request域中
                request.setAttribute("msg", "用户名以存在！");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
//        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //      可用
//                调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            //把回显信息，保存到request域中
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);

            System.out.println("code[" + code + "]错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

}
