package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.exception.UserNameNotExistException;
import com.exception.UserPasswordErrorException;
import com.service.UserService;


@Controller
@RequestMapping("/useroperation")
@SessionAttributes("user")
public class UserOperationAction {

    @Resource
    UserService userService;

    @RequestMapping("/checklogin")
    public ModelAndView checkLogin(User loginUser,ModelMap modelmap){

        ModelAndView mv = null;

        try {

            User successUser = userService.checkLogin(loginUser);
            System.out.println(successUser);
            //添加到Session中
            modelmap.addAttribute("user", successUser);
            //跳转到 主界面
            mv = new ModelAndView("user/info");

        } catch (UserNameNotExistException e) {
            modelmap.addAttribute("UNErrorMessage", e.getMessage());
            mv = new ModelAndView("loginForm");
        } catch (UserPasswordErrorException e) {
            modelmap.addAttribute("PWDErrorMessage", e.getMessage());
            mv = new ModelAndView("loginForm");
        }

        return mv;
    }
}
