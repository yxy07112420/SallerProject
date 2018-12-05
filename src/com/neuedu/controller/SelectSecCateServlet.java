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

@WebServlet(name = "SelectSecCateServlet",urlPatterns = "/SelectSecCateServlet")
public class SelectSecCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取传来的商品类表的父类id值
        String cate_par_id = req.getParameter("Cate_Par_Id");
        System.out.println("父类编号："+cate_par_id);
        if(cate_par_id != null){
            int i = Integer.parseInt(cate_par_id);
            //调用业务层
            CateBusiness cateBusiness = new CateBusinessImpl();
            List<Categroy> childCate = cateBusiness.getChildCate(i);
            JSONArray jsonArray = JSONArray.fromObject(childCate);
            System.out.println("jsonArray:"+jsonArray);
            resp.getWriter().write(jsonArray.toString());
        }
    }
}
