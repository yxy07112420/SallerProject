package com.neuedu.dao;

import com.neuedu.Util.JDBCUtil;
import com.neuedu.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> allUsers() {
        //连接数据库
        Connection conn = JDBCUtil.getConnection();
        //执行sql语句
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from User");
            rs = ps.executeQuery();
            while (rs.next()){
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_Name");
                String user_psw = rs.getString("User_psw");
                String user_email = rs.getString("User_email");
                String user_telPhone = rs.getString("User_telPhone");
                String user_regDate = rs.getString("User_regDate");
                User user = new User(user_id,user_name,user_psw,user_email,user_telPhone,user_regDate);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    //新增用户信息
    @Override
    public boolean addUser(User user) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into user(User_Name,User_psw,User_email,User_telPhone,User_regDate) values(?,?,?,?,?)");
            ps.setString(1,user.getUser_Name());
            System.out.println("psw"+user.getUser_psw());
            ps.setString(2,user.getUser_psw());
            ps.setString(3,user.getUser_email());
            ps.setString(4,user.getUser_telPhone());
            ps.setString(5, String.valueOf(user.getUser_regDate()));
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean idLogin(User user) {
        //创建连接
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from user where User_Name = ? and User_psw = ? ");
            ps.setString(1,user.getUser_Name());
            ps.setString(2,user.getUser_psw());
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
