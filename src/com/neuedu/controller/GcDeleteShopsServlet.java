package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GcDeleteShopsServlet",urlPatterns = "/GcDeleteShopsServlet")
public class GcDeleteShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传来的商品信息的id
        String shop_id = req.getParameter("shop_id");
        //业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        String sql = "delete from shop where Shop_id = ?";
        boolean exists = shopsBusiness.updateShopsIsExists(sql, shop_id);
        if(exists){
            System.out.println("彻底删除成功");
            resp.sendRedirect("GcShopsServlet");
        }else{
            System.out.println("彻底删除失败");
            resp.sendRedirect("GcShopsServlet");
        }
    }
}
