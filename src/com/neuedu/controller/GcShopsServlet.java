package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import com.neuedu.entity.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GcShopsServlet",urlPatterns = "/GcShopsServlet")
public class GcShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        System.out.println("Gc当前传来的页数："+pageNum);
        int changPage = 0;
        if(pageNum == null || "".equals(pageNum)){
            changPage = 1;
        }else {
            changPage = Integer.parseInt(pageNum);
        }
        //调用业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        Page shopsByPaging = shopsBusiness.getShopsByPaging(changPage, 5,1);
        System.out.println("gc:"+shopsByPaging);
        req.setAttribute("GcShops",shopsByPaging);
        req.getRequestDispatcher("GcShops.jsp").forward(req,resp);
    }
}
