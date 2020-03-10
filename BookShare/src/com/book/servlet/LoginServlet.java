package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Constants;
import com.book.exception.ServiceException;
import com.book.common.BeanFactory;
import com.book.dao.LoginDao;
import com.book.dao.LoginDaoimpl;
import com.book.entity.User;
import com.book.exception.ParaException;
import com.book.service.LoginService;
import com.book.service.LoginServiceimpl;

public class LoginServlet extends HttpServlet {
    
    //private LoginService loginService = new LoginServiceimpl();
    /**
     * 替代new关键字，使用BeanFactory
     */
    private LoginService loginService =(LoginService) BeanFactory.getInstance().getBean("loginService");
    
    
    private final String  WELCOME_PATH="/WEB-INF/jsp/welcome.jsp";
    private final String  LOGIN_PATH="/WEB-INF/jsp/login2.jsp";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
        
        
    }
        
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post方式处理请求参数乱码
        //request.setCharacterEncoding("utf-8");
        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("用户："+name+"，密码："+password+"正在登录---");
    
        try {
            
            User user = loginService.login(name, password);
            HttpSession session = request.getSession();
            user.setUserPassword("");
            session.setAttribute("USER", user);
            response.sendRedirect(request.getContextPath()+"/dashboard.action");
            
        } catch (ParaException e) {
            // TODO Auto-generated catch block
            Map<String, String> errormap = e.getErrormap();
            request.setAttribute("errormap", errormap);
            request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
            return ;
        } catch (ServiceException e) {
            System.out.println("ServiceException------------");
            int code = e.getCode();
            request.setAttribute(Constants.TIP_MESSAGE, e.getMessage()+"["+code+"]");
            request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
            return ;    
        }
        
        
    }
}
