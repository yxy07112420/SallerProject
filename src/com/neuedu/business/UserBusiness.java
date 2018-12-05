package com.neuedu.business;

import com.neuedu.entity.User;

import java.util.List;

public interface UserBusiness {
    //查看用户
    public List<User> allUser();
    //新增用户信息
    public boolean addUser(User user);
    //登录验证
    public boolean idLogin(User user);
}
