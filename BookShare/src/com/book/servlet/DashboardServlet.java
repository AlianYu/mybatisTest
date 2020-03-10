package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.BeanFactory;
import com.book.entity.Book;
import com.book.entity.KindBean;
import com.book.entity.PageBean;
import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.BookServiceimpl;

public class DashboardServlet extends HttpServlet {
    //private BookService bookservice = new BookServiceimpl();
    private BookService bookservice = (BookService) BeanFactory.getInstance().getBean("bookService");
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("USER");
        ArrayList<Book> bookList = bookservice.selectbyId(user.getUserId());
        request.setAttribute("bookList", bookList);
        session.setAttribute("state", 1);
        
        int count = bookservice.getBookCountByUserId(user.getUserId(),1);
        
        
        int out = bookservice.getBookCountByUserId(user.getUserId(),2);
        int in = bookservice.getBookCountByUserId(user.getUserId(),3);
        int borrewed = bookservice.getBookCountByUserId(user.getUserId(),4);
        KindBean kindbean  = new KindBean(count,out,in,borrewed);
        session.setAttribute("kindbean", kindbean);
        
        
        
        
        PageBean pageBean = new PageBean();
        //初始化pageBean
        pageBean.setCurrentPage(1);//当前页数
        pageBean.setTotalcount(count);//总数量
        pageBean.setPagesize(5);//一页数目
        //总页数无setter方法,偏移量无setter方法
        request.setAttribute("pageBean", pageBean);
    
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        
        
        
        
        
        
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post方式处理请求参数乱码
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
