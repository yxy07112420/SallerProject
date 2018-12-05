package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import com.neuedu.entity.Shop;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllShopsServlet",urlPatterns = "/AllShopsServlet")
public class AllShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //业务层
        ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
        List<Shop> shops = shopsBusiness.getShops();
        JSONArray jsonArray = JSONArray.fromObject(shops);
        resp.getWriter().write(jsonArray.toString());
    }
}
