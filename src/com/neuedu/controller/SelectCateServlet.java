package com.neuedu.controller;

import com.neuedu.Util.JDBCUtil;
import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;
import com.neuedu.entity.Categroy;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectCateServlet",urlPatterns = "/SelectCateServlet")
public class SelectCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取父类
        CateBusiness cateBusiness = new CateBusinessImpl();
        List<Categroy> parCate = cateBusiness.getParCate();
//        System.out.println("parCate:"+parCate);
//        req.setAttribute("ParCate",parCate);
//        req.getRequestDispatcher("InsertShops.jsp").forward(req,resp);
        JSONArray jsonArray = JSONArray.fromObject(parCate);
        System.out.println("一级标题："+jsonArray);
        resp.getWriter().write(jsonArray.toString());
    }
}
