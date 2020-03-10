package com.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * PageEncodingFilter干的事情：
 * 
 * 
 * @author ylq
 *
 */
public class PageEncodingFilter implements Filter {
    
    private String encoding="utf-8";
    protected FilterConfig filterConfig;

    
    //为一个请求过来配置一个utf-8的编码
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.filterConfig=filterConfig;
        if(filterConfig.getInitParameter("encoding") !=null) {
            encoding = filterConfig.getInitParameter("encoding");
        }
    }
    
    
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        
        String uri = request.getRequestURI();
        String requestUri = uri.substring(request.getContextPath().length()+1);
        
        //System.out.println(uri+" = "+requestUri);
        //请求继续往下走
        filterChain.doFilter(request, servletResponse);
    }
    
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    

    

}
