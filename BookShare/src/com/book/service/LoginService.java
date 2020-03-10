package com.book.service;

import java.util.ArrayList;


import com.book.exception.ParaException;
import com.book.exception.ServiceException;
import com.book.entity.User;

public interface LoginService {
    
    

    User login(String username,String pwd) throws ParaException, ServiceException;
}
