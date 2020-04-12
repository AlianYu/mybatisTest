package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 数据库mysql
 * @author ylq
 *
 */
@Controller
@RequestMapping("/test")
public class FirstAction {

    @RequestMapping("/first")
    public String login(){
        return "first";
    }

}
