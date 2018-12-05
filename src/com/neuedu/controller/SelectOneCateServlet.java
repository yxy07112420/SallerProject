package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;
import com.neuedu.entity.Categroy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectOneCateServlet",urlPatterns = "/SelectOneCateServlet")
public class SelectOneCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传来的商品类别编号
        String cate_id = req.getParameter("cate_id");
        System.out.println("类别编号："+cate_id);
        //业务层
        CateBusiness cateBusiness = new CateBusinessImpl();
        Categroy oneCate = cateBusiness.getOneCate(Integer.parseInt(cate_id));
        //查询一级类别
        Categroy oneCate1 = cateBusiness.getOneCate(oneCate.getCate_Parent_Id());
        String cate_name = oneCate1.getCate_Name();
        req.setAttribute("cate",oneCate);
        req.setAttribute("firstName",oneCate1);
        req.getRequestDispatcher("updateCategroys.jsp").forward(req,resp);
    }
}
