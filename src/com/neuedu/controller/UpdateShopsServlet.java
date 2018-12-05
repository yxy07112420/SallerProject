package com.neuedu.controller;

import com.neuedu.business.ShopsBusiness;
import com.neuedu.business.ShopsBusinessImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "updateShopsServlet",urlPatterns = "/updateShopsServlet")
public class UpdateShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //响应乱码
        resp.setCharacterEncoding("utf-8");
        //创建一个工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");
        //获取商品名
        String shopName = null;
        //获取商品的类型
        int shopType = 0;
        //获取商品的二级类型
        Integer secShopType = null;
        //最终的商品类型
        int lastShopType = 0;
        //获取商品的价格
        String shopMoney = null;
        //获取商品的库存量
        String shopNumber = null;
        //获取商品的简介
        String shopconter = null;
        //获取商品的id值
        int shopId = 0;
        //图片名称
        String imgName = null;
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f:fileItems) {
                if(!f.isFormField()){
                    if(!"".equals(f.getName())&&f.getName() != null){
                        imgName = f.getName();
                        System.out.println("图片名："+imgName);
                        //拿到问价字节输入流
                        InputStream inputStream = f.getInputStream();
                        //创建文件
                        File file = new File("d:/imgs/"+imgName);
                        //拿到字节输出流
                        OutputStream outputStream = new FileOutputStream(file);
                        //创建byte数组
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(bytes)) != -1){
                            //将图片存在本地文件中
                            outputStream.write(bytes,0,len);
                        }
                        outputStream.flush();
                        //关闭资源
                        outputStream.close();
                        inputStream.close();
                    }
                }
                if(f.isFormField()){
                    System.out.println("我不是file");
                    if("shop_name".equals(f.getFieldName())){
                        shopName = f.getString("utf-8");
                        System.out.println("商品名："+shopName);
                    }
                    if("cate_name".equals(f.getFieldName())){
                        shopType = Integer.parseInt(f.getString("utf-8"));
                    }
                    if("shop_price".equals(f.getFieldName())){
                        shopMoney = f.getString();
                        System.out.println("商品价格："+shopMoney);
                    }
                    if("shop_stock".equals(f.getFieldName())){
                        shopNumber = f.getString();
                        System.out.println("商品库存："+shopNumber);
                    }
                    //商品简介
                    if("shop_des".equals(f.getFieldName())){
                        shopconter = f.getString("utf-8");
                    }
                    //商品编号
                    if("shop_id".equals(f.getFieldName())){
                        shopId = Integer.parseInt(f.getString("utf-8"));
                    }
                    if("cate_child_name".equals(f.getFieldName())){
                        if(f.getString("utf-8") == null){
                            secShopType =null;
                        }else {
                            secShopType = Integer.parseInt(f.getString("utf-8"));
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
//        //获取当前用户信息
//        Object massage = req.getSession().getAttribute("massage");
//        System.out.println("massage"+(String)massage);
        //获取当前时间
//        Date nowDate = new Date();
//        SimpleDateFormat times = new SimpleDateFormat("yyyy-MM-dd");
//        String checkdate = times.format(nowDate);
        //判断是否有二级类型
        if(secShopType == null){
            lastShopType = shopType;
        }else {
            lastShopType = secShopType;
        }
        ShopsBusiness updateShopsDemo = new ShopsBusinessImpl();
        String sql = null;
        boolean b = false;
        if(imgName != null){
            sql = "update shop set Shop_Name= ? , Shop_Cate_id = ? ,Shop_price = ?,Shop_Stock = ?,Shop_des = ?,Shop_img = ? where Shop_id = ?";
            b = updateShopsDemo.updateShopsIsExists(sql, shopName, lastShopType, shopMoney, shopNumber, shopconter, imgName,shopId);
        }else {
            sql = "update shop set Shop_Name = ? , Shop_Cate_id = ? ,Shop_price = ?,Shop_Stock = ?,Shop_des = ? where Shop_id = ?";
            b = updateShopsDemo.updateShopsIsExists(sql, shopName, lastShopType, shopMoney, shopNumber, shopconter,shopId);
        }
        if(b){
            req.getRequestDispatcher("ShopsServlet").forward(req,resp);
            System.out.println("修改成功");
            return;
        }else {
            req.setAttribute("shopId",shopId);
            req.getRequestDispatcher("SelectOneShopServlet").forward(req,resp);
            System.out.println("修改失败");
            return;
        }
    }
}
