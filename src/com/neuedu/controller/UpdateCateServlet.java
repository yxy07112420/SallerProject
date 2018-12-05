package com.neuedu.controller;

import com.neuedu.business.CateBusiness;
import com.neuedu.business.CateBusinessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCateServlet",urlPatterns = "/UpdateCateServlet")
public class UpdateCateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取传来的数据信息
        String cate_id = req.getParameter("cate_id");
        String cate_name = req.getParameter("cate_Name");
        String firstName = req.getParameter("firstName");
        //调用业务层
        CateBusiness cateBusiness = new CateBusinessImpl();
        String sql = "update categroy set cate_Name = ?,cate_Parent_id = ? where cate_id = ?";
        boolean b = cateBusiness.updateCate(sql, cate_name, firstName, cate_id);
        if(b == true){
            req.setAttribute("result","修改成功");
            req.getRequestDispatcher("CategroysServlet").forward(req,resp);
        }else {
            req.setAttribute("result","修改失败");
            req.getRequestDispatcher("SelectOneCateServlet?cate_id="+cate_id).forward(req,resp);
        }
    }
}
