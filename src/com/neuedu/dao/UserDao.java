package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {
    //查询所有的用户信息
    public List<User> allUsers();
    //新增用户信息
    public boolean addUser(User user);
    //登录验证
    public boolean idLogin(User user);
}
