package com.neuedu.controller;

import com.neuedu.business.UserBusiness;
import com.neuedu.business.UserBusinessImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginSuccessServlet",urlPatterns = "/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if(username!= null && !"".equals(username)&&password!= null && !"".equals(password)){
            User user = new User();
            user.setUser_Name(username);
            user.setUser_psw(password);
            //执行业务层
            UserBusiness userBusiness = new UserBusinessImpl();
            boolean b = userBusiness.idLogin(user);
            if(b == true){
                //创建cookie
                Cookie cookie = new Cookie("userName", URLEncoder.encode(username,"utf-8"));
                Cookie cookie1 = new Cookie("password",password);
                cookie.setMaxAge(3600);
                cookie1.setMaxAge(3600);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
                req.getSession().setAttribute("username",username);
                req.getSession().setAttribute("password",password);
                resp.sendRedirect("index.jsp");
            }else {
                req.setAttribute("error","请确保用户名和密码正确");
                req.getRequestDispatcher("Login.jsp").forward(req,resp);
            }
        }else {
            Cookie[] cookies = req.getCookies();
            if(cookies!=null){
                for (Cookie c:cookies) {
                    if("username".equals(c.getName())){
                        System.out.println("我进来了");
                        req.getSession().setAttribute("username",username);
                        req.getSession().setAttribute("password",password);
                        resp.sendRedirect("index.jsp");
                        return;
                    }else {
                        resp.sendRedirect("Login.jsp");
                        return;
                    }
                }
            }
            resp.sendRedirect("Login.jsp");
        }
    }
}
