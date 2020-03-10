package com.book.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.book.exception.ServiceException;
import com.book.exception.ParaException;
import com.book.common.BeanFactory;
import com.book.dao.LoginDao;
import com.book.dao.LoginDaoimpl;
import com.book.entity.User;

public class LoginServiceimpl implements LoginService{
    
    
    
    
    //private LoginDao logindao = new LoginDaoimpl();
    
    //工厂方式创建logindao
    private LoginDao logindao = (LoginDao) BeanFactory.getInstance().getBean("loginDao");
    
    /*private LoginDao logindao;
    
    public void setLoginDao(LoginDao logindao) {
        this.logindao = logindao;
    }*/






    @Override
    public User login(String username, String pwd) throws ParaException, ServiceException{
        // TODO Auto-generated method stub
        ParaException parameterException = new ParaException();
        
        if(username ==null || username.equals("")) {
            parameterException.addErrorField("UserNameERROR", "UserName is required");
            
        }
        if(pwd ==null || pwd.equals("")) {
            parameterException.addErrorField("PasswordERROR", "Password is required");
        }
        
        if(parameterException.isErrorField()) {
            throw parameterException;
        }
        System.out.println(logindao);
        User userDB = logindao.selectByName(username);
        
        if (userDB.getUserName() ==null || userDB.getUserName().equals("")) {
            throw new ServiceException(1000,"用户不存在");
        }
        if(userDB.getUserPassword() ==null || userDB.getUserPassword().equals("") || !userDB.getUserPassword().equals(pwd)) {//密码错误
            throw new ServiceException(1001,"密码错误");
        }
        
        return userDB;
    }

    

}
