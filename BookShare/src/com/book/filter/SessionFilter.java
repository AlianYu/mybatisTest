package com.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.entity.User;

public class SessionFilter implements Filter{
    
    private String notNeedLoginPages;
    protected FilterConfig filterConfig;
    
    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.filterConfig=filterConfig;
        if(filterConfig.getInitParameter("notNeedLoginPages") !=null) {
            notNeedLoginPages = filterConfig.getInitParameter("notNeedLoginPages");
            
        }
    }


    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        String uri = request.getRequestURI();
        String requestUri = uri.substring(request.getContextPath().length()+1);
        System.out.println("sessionFilter中="+requestUri);
        String [] pages = notNeedLoginPages.split(",");
        boolean isAllow = false;
        for(String page:pages) {
            if(page.equals("requestUri")) {
                isAllow=true;
                break;
            }
            if(requestUri.endsWith(".css") || requestUri.endsWith(".js") ||requestUri.endsWith(".png") || requestUri.endsWith("jpg")) {
                isAllow=true;
                break;
            }
        }
        if(isAllow) {
            filterChain.doFilter(request, response);
            System.out.println("放行-----------------");
            
        }else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("USER");
        
            if(user ==null) {
                //没有user就跳到登录页面
                System.out.println("跳到登录界面-----------------");
                response.sendRedirect(request.getContextPath()+"/login");
            }else {
                filterChain.doFilter(request, response);
            }
        }
    }

    
}
