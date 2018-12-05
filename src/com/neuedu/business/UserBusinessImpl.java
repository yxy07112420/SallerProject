package com.neuedu.business;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;

import java.util.List;

public class UserBusinessImpl implements UserBusiness {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> allUser() {
        return userDao.allUsers();
    }
    //新增用户信息
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
    @Override
    public boolean idLogin(User user) {
        return userDao.idLogin(user);
    }
}
