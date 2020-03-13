package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonPageAction {


    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
