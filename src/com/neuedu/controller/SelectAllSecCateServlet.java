package com.neuedu.controller;

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

@WebServlet(name = "SelectAllSecCateServlet",urlPatterns = "/SelectAllSecCateServlet")
public class SelectAllSecCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取父类
        CateBusiness cateBusiness = new CateBusinessImpl();
        List<Categroy> childCate = cateBusiness.getChildCate();
        JSONArray jsonArray = JSONArray.fromObject(childCate);
        System.out.println("二级标题："+jsonArray);
        resp.getWriter().write(jsonArray.toString());
    }
}
