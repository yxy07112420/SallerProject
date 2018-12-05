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
import java.util.List;

@WebServlet(name = "AddShopsServlet",urlPatterns = "/AddShopsServlet")
public class AddShopsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取前端传来的信息
        //创建一个工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");
        //文件名
        String shopImages = null;
        //商品编号
        String shopId = null;
        //获取商品名
        String shopName = null;
        //获取商品的类型
        int shopType = 0;
        //获取商品的二级类型
        Integer secShopType = null;
        //最终的商品类型
        int lastShopType = 0;
        //获取商品的售价
        String shopMoney = null;
        //获取商品的库存量
        int shopNumber = 0;
        //商品简介
        String shopDescribe = null;
        if(shopImages == null){
            shopImages = "logo.svg";
        }
        try {
            //存放inpu域
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f:fileItems) {
                //file
                if(!f.isFormField()){
                    if(f.getName()!=null&&!"".equals(f.getName())){
                        //获取上传的文件名
                        shopImages = f.getName();
                        System.out.println("商品的图片名："+shopImages);
                        System.out.println("文件");
                        //拿到问价字节输入流
                        InputStream inputStream = f.getInputStream();
                        //创建文件
                        File file = new File("d:/imgs/"+shopImages);
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
                //不是file
                if(f.isFormField()){
                    //判断商品编号
                    if("shop_id".equals(f.getFieldName())){
                        shopId = f.getString("utf-8");
                    }
                    //商品名
                    if("shop_name".equals(f.getFieldName())){
                        shopName = f.getString("utf-8");
                    }
                    //商品类型
                    if("shop_price".equals(f.getFieldName())){
                        shopMoney = f.getString();
                    }
                    //商品库存
                    if("shop_stock".equals(f.getFieldName())){
                        shopNumber = Integer.parseInt(f.getString("utf-8"));
                    }
                    //商品类别
                    if("cate_name".equals(f.getFieldName())){
                        System.out.println("编号名："+f.getString());
                        shopType = Integer.parseInt(f.getString("utf-8"));
                    }
                    //二级商品类别
                    if("cate_child_name".equals(f.getFieldName())){
                        if(f.getString("utf-8") == null){
                            secShopType =null;
                        }else {
                            secShopType = Integer.parseInt(f.getString("utf-8"));
                        }
                    }
                    //商品介绍
                    if("shop_des".equals(f.getFieldName())){
                        shopDescribe = f.getString("utf-8");
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if(shopImages == null){
            shopImages = "logo.svg";
        }
        System.out.println("商品介绍"+shopDescribe);
        if(shopDescribe == null || "".equals(shopDescribe)){
            shopDescribe ="该商品暂无先关的简介";
        }
        //判断是否有二级类型
        if(secShopType == null){
            lastShopType = shopType;
        }else {
            lastShopType = secShopType;
        }
        ShopsBusiness insertShops = new ShopsBusinessImpl();
        String sql = "insert into shop(shop_id,shop_name,shop_des,shop_img,shop_price,shop_cate_id,shop_stock,shop_IsGc) values (?,?,?,?,?,?,?,?)";
        boolean b = insertShops.updateShopsIsExists(sql, shopId, shopName, shopDescribe, shopImages, shopMoney, lastShopType, shopNumber, 0);
        if(b){
            //跳转到查询商品的界面
            System.out.println("注册成功");
            resp.sendRedirect("ShopsServlet");
        }else {
            //当前界面
            System.out.println("注册失败");
            resp.sendRedirect("InsertShops.jsp");
        }
    }
}
