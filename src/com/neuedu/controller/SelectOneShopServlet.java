package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;
import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import com.neuedu.entity.Categroy;
import com.neuedu.entity.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectOneShopServlet",urlPatterns = "/SelectOneShopServlet")
public class SelectOneShopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品的id
        String shop_id = req.getParameter("shop_id");
        System.out.println("shop_id:"+shop_id);
        if(shop_id!=null&&!"".equals(shop_id)){
            //执行业务层
            ShopsBusiness shopsBusiness = new ShopsBusinessImpl();
            //执行商品类型的业务层
            CateBusiness c = new CateBusinessImpl();
            List<Categroy> parCate = c.getParCate();
            List oneShop = shopsBusiness.getOneShop(shop_id);
            System.out.println("shopSize:"+oneShop);
            if(oneShop != null){
                req.setAttribute("shop",(Shop)oneShop.get(0));
                req.setAttribute("cate_name",(String)oneShop.get(1));
                req.setAttribute("cates",parCate);
                req.getRequestDispatcher("updateShops.jsp").forward(req,resp);
                return;
            }else {
                req.getRequestDispatcher("updateShops.jsp").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("updateShops.jsp").forward(req,resp);
        }

    }
}
