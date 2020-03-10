package com.book.dao;

import java.util.ArrayList;

import com.book.entity.User;

public interface LoginDao {
    

    
    User selectByName(String username);

}
