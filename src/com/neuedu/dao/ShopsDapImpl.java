package com.neuedu.dao;

import com.neuedu.Util.JDBCUtil;
import com.neuedu.entity.Shop;
import jdk.nashorn.internal.scripts.JD;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopsDapImpl implements ShopsDao {
    //查询（在回收站中和没有在回收站中）
    @Override
    public int getAllRecords(int isGc) {
        //连接数据库
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) as num from Shop where Shop_IsGc = ?");
            ps.setInt(1,isGc);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeIo(conn,ps,rs);
        }
        return 0;
    }
    //分页查询商品信息
    @Override
    public Map<Shop, String> getShopByLimit(int startIndex, int pageSize,int isGc) {
        //连接数据库
        Connection conn = JDBCUtil.getConnection();
        //执行sql语句
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<Shop,String> map = new HashMap<>();
        try {
            ps = conn.prepareStatement("select Shop.* ,Cate_Name from Shop left join Categroy on Shop.Shop_Cate_id = Categroy.Cate_id where Shop_IsGc = ? LIMIT ?,?");
            ps.setInt(1,isGc);
            ps.setInt(2,startIndex);
            ps.setInt(3,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String shop_id = rs.getString("Shop_id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_prices = rs.getBigDecimal("Shop_price");
                int shop_cate_id = rs.getInt("Shop_Cate_id");
                int shop_stock = rs.getInt("Shop_Stock");
                byte shop_isGc = rs.getByte("Shop_IsGc");
                String cate_name = rs.getString("Cate_Name");
                Shop shop = new Shop(id,shop_id,shop_name,shop_des,shop_img,shop_prices,shop_cate_id,shop_stock,shop_isGc);
                map.put(shop,cate_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeIo(conn,ps,rs);
        }
        return map;
    }
    //修改商品信息
    @Override
    public boolean updateShopsIsExists(String sql,Object...objects) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int  i = 0;i < objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //查询所有的商品信息
    @Override
    public List<Shop> getShops() {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Shop> shops = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from shop");
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String shop_id = rs.getString("Shop_id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_prices = rs.getBigDecimal("Shop_price");
                int shop_cate_id = rs.getInt("Shop_Cate_id");
                int shop_stock = rs.getInt("Shop_Stock");
                byte shop_isGc = rs.getByte("Shop_IsGc");
                Shop shop = new Shop(id,shop_id,shop_name,shop_des,shop_img,shop_prices,shop_cate_id,shop_stock,shop_isGc);
                shops.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeIo(conn,ps,rs);
        }
        return shops;
    }
//根据商品id查询单个商品信息
    @Override
    public Shop getOneShop(String shop_id) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from shop where Shop_id = ?");
            ps.setString(1,shop_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_prices = rs.getBigDecimal("Shop_price");
                int shop_cate_id = rs.getInt("Shop_Cate_id");
                int shop_stock = rs.getInt("Shop_Stock");
                byte shop_isGc = rs.getByte("Shop_IsGc");
                Shop shop = new Shop(id,shop_id,shop_name,shop_des,shop_img,shop_prices,shop_cate_id,shop_stock,shop_isGc);
                return shop;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Shop> getShops(int shop_cate_id) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Shop> shops = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from shop where Shop_Cate_id = ?");
            ps.setInt(1,shop_cate_id);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String shop_id = rs.getString("Shop_id");
                String shop_name = rs.getString("Shop_Name");
                String shop_des = rs.getString("Shop_des");
                String shop_img = rs.getString("Shop_img");
                BigDecimal shop_prices = rs.getBigDecimal("Shop_price");
                int shop_stock = rs.getInt("Shop_Stock");
                byte shop_isGc = rs.getByte("Shop_IsGc");
                Shop shop = new Shop(id,shop_id,shop_name,shop_des,shop_img,shop_prices,shop_cate_id,shop_stock,shop_isGc);
                shops.add(shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeIo(conn,ps,rs);
        }
        return shops;
    }
}
