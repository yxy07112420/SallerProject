package com.neuedu.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil  {
    //创建连接池
    //创建连接池
    private static DataSource dataSource = null;
    public static DataSource getDataSource() {
        try {
            if(dataSource == null) {
                dataSource = DruidDataSourceFactory.createDataSource(getProperties());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    //获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //读取文件
    public static Properties getProperties() {
        Properties p = new Properties();
        InputStream inputStream = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
    //创建关闭资源的方法
    public static void closeIo(Connection conn, PreparedStatement ps, ResultSet rs){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
