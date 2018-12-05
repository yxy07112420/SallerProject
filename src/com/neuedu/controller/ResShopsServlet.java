package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResShopsServlet",urlPatterns = "/ResShopsServlet")
public class ResShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传来的商品id
        String shop_id = req.getParameter("shop_id");
        //业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        String sql = "update shop set Shop_isGc = ? where Shop_id = ?";
        boolean exists = shopsBusiness.updateShopsIsExists(sql, 0, shop_id);
        if(exists){
            System.out.println("还原成功");
            resp.sendRedirect("GcShopsServlet");
        }else{
            System.out.println("还原失败");
            resp.sendRedirect("GcShopsServlet");
        }

    }
}
