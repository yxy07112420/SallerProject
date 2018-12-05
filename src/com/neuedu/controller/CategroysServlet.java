package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;
import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import com.neuedu.dao.CateDao;
import com.neuedu.entity.Page;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategroysServlet",urlPatterns = "/CategroysServlet")
public class CategroysServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传来的父类
        String cate_par_id = req.getParameter("firstName");
        String pageNum = req.getParameter("pageNum");
        System.out.println("当前传来的页数："+pageNum);
        System.out.println("传来的父类id:"+cate_par_id);
        int changPage = 0;
        if(pageNum == null || "".equals(pageNum)){
            changPage = 1;
        }else {
            changPage = Integer.parseInt(pageNum);
        }
        System.out.println("changePage:"+changPage);
        //调用业务层
//        CateDao shopsBusiness = new ShopsBusinessImpl();
        CateBusiness cateBusiness = new CateBusinessImpl();
        Page cateByLimite = null;
        if (cate_par_id!=null&&!"".equals(cate_par_id)&&!cate_par_id.equals("chose")){
            Integer integer = Integer.valueOf(cate_par_id);
            cateByLimite = cateBusiness.getCateByLimite(changPage, 10,integer);
        }else {
            cateByLimite = cateBusiness.getCateByLimite(changPage, 8,null);
        }
        System.out.println("cate:"+cateByLimite.getCates());
        req.setAttribute("cates",cateByLimite);
        req.setAttribute("firstName",cate_par_id);
//        JSONArray jsonArray = JSONArray.fromObject(cateByLimite);
//        resp.getWriter().write(jsonArray.toString());
        req.getRequestDispatcher("SelectCategroys.jsp").forward(req,resp);

    }
}
