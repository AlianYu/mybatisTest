package com.service;

import com.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userdao) {
        this.userDao = userdao;
    }

    public void save() {
        userDao.save();
    }

}
