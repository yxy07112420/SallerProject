package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;
import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import com.neuedu.entity.Categroy;
import com.neuedu.entity.Page;
import com.neuedu.entity.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShopsServlet",urlPatterns = "/ShopsServlet")
public class ShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        System.out.println("当前传来的页数："+pageNum);
        int changPage = 0;
        if(pageNum == null || "".equals(pageNum)){
            changPage = 1;
        }else {
            changPage = Integer.parseInt(pageNum);
        }
        System.out.println("changePage:"+changPage);
        //调用业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        Page shopsByPaging = shopsBusiness.getShopsByPaging(changPage, 5,0);
        req.setAttribute("shops",shopsByPaging);
        req.getRequestDispatcher("SelectShops.jsp").forward(req,resp);
    }
}
