package com.neuedu.dao;

import com.neuedu.Util.JDBCUtil;
import com.neuedu.entity.Categroy;
import jdk.nashorn.internal.scripts.JD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CateDaoImpl implements CateDao {
    @Override
    public Categroy getOneCate(int Cate_id) {
        //创建数据库连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Categroy> categroys = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from Categroy where Cate_id = ?");
            ps.setInt(1,Cate_id);
            rs = ps.executeQuery();
            if (rs.next()){
                int cate_id = rs.getInt("Cate_id");
                String cate_name = rs.getString("Cate_Name");
                int cate_parent_id = rs.getInt("Cate_Parent_id");
                Categroy categroy = new Categroy(cate_id,cate_name,cate_parent_id);
                return categroy;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Categroy> getParCategroy() {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Categroy> categroys = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from Categroy where Cate_Parent_id = 0");
            rs = ps.executeQuery();
            while (rs.next()){
                int cate_id = rs.getInt("Cate_id");
                String cate_name = rs.getString("Cate_Name");
                int cate_parent_id = rs.getInt("Cate_Parent_id");
                Categroy categroy = new Categroy(cate_id,cate_name,cate_parent_id);
                categroys.add(categroy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categroys;
    }
    //根据父类Id查看子类
    @Override
    public List<Categroy> getSecondCate(int cate_par_id) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Categroy> categroys = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from Categroy where Cate_Parent_id =?");
            ps.setInt(1,cate_par_id);
            rs = ps.executeQuery();
            while (rs.next()){
                int cate_id = rs.getInt("Cate_id");
                String cate_name = rs.getString("Cate_Name");
                int cate_parent_id = rs.getInt("Cate_Parent_id");
                Categroy categroy = new Categroy(cate_id,cate_name,cate_parent_id);
                categroys.add(categroy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categroys;
    }
    //查询所有的二级类别
    @Override
    public List<Categroy> getSecondCate() {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Categroy> categroys = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from Categroy where Cate_Parent_id != 0");
            rs = ps.executeQuery();
            while (rs.next()){
                int cate_id = rs.getInt("Cate_id");
                String cate_name = rs.getString("Cate_Name");
                int cate_parent_id = rs.getInt("Cate_Parent_id");
                Categroy categroy = new Categroy(cate_id,cate_name,cate_parent_id);
                categroys.add(categroy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categroys;
    }

    //查询所有商品类别
    @Override
    public int getAllRecords() {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(*) as count1 from Categroy");
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("count1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Map<Categroy, String> getCateByLimit(int startIndex, int pageSize,Integer cate_par_id) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<Categroy,String> m = new HashMap<>();
        try {
            if(cate_par_id == null){
                ps = conn.prepareStatement("select c1.*,c2.Cate_Name as Par_Name from categroy c1 left join categroy c2 on c1.Cate_Parent_id = c2.Cate_id limit ?,?");
                ps.setInt(1,startIndex);
                ps.setInt(2,pageSize);
            }else {
                ps = conn.prepareStatement("select c1.*,c2.Cate_Name as Par_Name from categroy c1 left join categroy c2 on c1.Cate_Parent_id = c2.Cate_id where c1.Cate_Parent_id = ? limit ?,?");
                ps.setInt(1,cate_par_id);
                ps.setInt(2,startIndex);
                ps.setInt(3,pageSize);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                int cate_id = rs.getInt("Cate_id");
                String cate_name = rs.getString("Cate_Name");
                int cate_parent_id = rs.getInt("Cate_Parent_id");
                String par_name = rs.getString("Par_Name");
                Categroy c = new Categroy(cate_id,cate_name,cate_parent_id);
                m.put(c,par_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    //对商品类别信息进行修改操作(包括增删改操作)
    @Override
    public boolean updateCate(String sql, Object... objects) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i =0;i < objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            int i = ps.executeUpdate();
            if(i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
