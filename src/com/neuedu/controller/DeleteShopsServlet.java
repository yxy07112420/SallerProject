package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteShopsServlet",urlPatterns = "/DeleteShopsServlet")
public class DeleteShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        String shop_id = req.getParameter("shop_id");
        System.out.println("要删除的商品id:"+shop_id);
        //业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        String sql = "update shop set Shop_IsGc = ? where Shop_id = ?";
        boolean exists = shopsBusiness.updateShopsIsExists(sql, 1, shop_id);
        if(exists){
            System.out.println("删除成功");
            resp.sendRedirect("ShopsServlet");
        }else{
            System.out.println("删除失败");
            resp.sendRedirect("ShopsServlet");
        }
    }
}
