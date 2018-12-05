package com.neuedu.controller;

import com.neuedu.business.UserBusiness;
import com.neuedu.business.UserBusinessImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddUsersServlet",urlPatterns = "/AddUsersServlet")
public class AddUsersServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //转码
        req.setCharacterEncoding("utf-8");
        //获取前端传来的数据
        String username = req.getParameter("username");
        System.out.println("username"+username);
        String password = req.getParameter("password");
        System.out.println("password"+password);
        String telPhone = req.getParameter("telPhone");
        System.out.println("telPhone"+telPhone);
        String email = req.getParameter("email");
        System.out.println("email"+email);
        //获取当前时间
        Date nowDate = new Date();
        SimpleDateFormat times = new SimpleDateFormat("yyyy-MM-dd");
        String checkdate = times.format(nowDate);
        //创建用户实例对象
        User user = new User(null,username,password,email,telPhone,checkdate);
        System.out.println("user:"+user);
        //调用业务层
        UserBusiness userBusiness = new UserBusinessImpl();
        boolean b = userBusiness.addUser(user);
        if(b == true){
            req.setAttribute("result","注册成功");
            req.getRequestDispatcher("addUsers.jsp").forward(req,resp);
        }else {
            req.setAttribute("result","注册失败");
            req.getRequestDispatcher("addUsers.jsp").forward(req,resp);
        }
    }
}
