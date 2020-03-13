package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;
import com.exception.UserNameNotExistException;
import com.exception.UserPasswordErrorException;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public User checkLogin(User user) throws UserNameNotExistException, UserPasswordErrorException {
        // TODO Auto-generated method stub
        User successUser = userDao.FindByUsername(user.getUserName());

        if(successUser == null){
            throw new UserNameNotExistException("用户名不存在");
        }

        if(!user.getPassword().equals(successUser.getPassword())){
            throw new UserPasswordErrorException("密码不正确");
        }

        return successUser;
    }

}
