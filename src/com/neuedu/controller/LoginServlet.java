package com.neuedu.controller;

import com.neuedu.business.UserBusiness;
import com.neuedu.business.UserBusinessImpl;
import com.neuedu.entity.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //创建User对象
        UserBusiness userBusiness = new UserBusinessImpl();
        List<User> users = userBusiness.allUser();
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
