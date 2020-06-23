package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {

    @RequestMapping("/hello")
    public String hello() {
        return "/hello";
    }

    @RequestMapping("/sumbit")
    public ModelAndView sumbit(String username,String password,String[] hobby) {
        System.out.println("用户名："+username+"密码："+password);
        for(String h :hobby) {
            System.out.println(h);
        }
        return null;

    }

}
