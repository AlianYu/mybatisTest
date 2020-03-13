package com.service;

import com.entity.User;
import com.exception.UserNameNotExistException;
import com.exception.UserPasswordErrorException;

public interface UserService {

    User checkLogin(User user) throws UserNameNotExistException,UserPasswordErrorException;
}
