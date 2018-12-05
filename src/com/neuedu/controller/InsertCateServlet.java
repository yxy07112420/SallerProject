package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertCateServlet",urlPatterns = "/InsertCateServlet")
public class InsertCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取传来的父类id
        String firstName = req.getParameter("firstName");
        //获取传来的二级标题名
        String secName = req.getParameter("secName");
        //调用业务层
        CateBusiness cateBusiness = new CateBusinessImpl();
        String sql = "insert into Categroy(Cate_Name,Cate_Parent_id) values (?,?)";
        boolean b = cateBusiness.updateCate(sql, secName, firstName);
        if(b == true){
            req.setAttribute("result","添加成功");
            System.out.println("添加成功");
            req.getRequestDispatcher("insertCategroys.jsp").forward(req,resp);
        }else {
            req.setAttribute("result","添加失败");
            System.out.println("添加失败");
            req.getRequestDispatcher("insertCategroys.jsp").forward(req,resp);
        }
    }
}
