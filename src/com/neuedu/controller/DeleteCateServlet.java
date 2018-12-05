package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCateServlet",urlPatterns = "/DeleteCateServlet")
public class DeleteCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传来的商品类别编号
        String cate_id = req.getParameter("cate_id");
        System.out.println("要删除的商品编号信息："+cate_id);
        if(cate_id == null){
            System.out.println("删除失败1");
            req.setAttribute("result","删除失败");
            req.getRequestDispatcher("CategroysServlet").forward(req,resp);
            return;
        }
        //创建业务层
        CateBusiness cateBusiness = new CateBusinessImpl();
        boolean b = cateBusiness.deleteCate(Integer.parseInt(cate_id));
        if(b== true){
            System.out.println("删除成功");
            req.setAttribute("result","删除成功");
            req.getRequestDispatcher("CategroysServlet").forward(req,resp);
        }else {
            System.out.println("删除失败");
            req.setAttribute("result","删除失败");
            req.getRequestDispatcher("CategroysServlet").forward(req,resp);
        }
    }
}
