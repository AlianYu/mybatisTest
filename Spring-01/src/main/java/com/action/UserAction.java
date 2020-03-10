package com.action;

import com.service.UserService;

public class UserAction {

    private UserService userService ;

    public void setUserService(UserService userservice) {
        this.userService = userservice;
    }

    public void save() {
        userService.save();
    }

}
