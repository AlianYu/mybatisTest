package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class BookPageServlet extends HttpServlet {
    
    
    //private BookService bookservice = new BookServiceimpl();
    private BookService bookservice = (BookService) BeanFactory.getInstance().getBean("bookService");
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(currentPageStr);
        System.out.println("当前页="+currentPage);
        
        
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("USER");
        int count = bookservice.getBookCountByUserId(user.getUserId(),1);
        System.out.println(user.getUserName()+"拥有"+count+"本书--------------");
        
        
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalcount(count);
        pageBean.setPagesize(5);//一页数目
        //总页数无setter方法,偏移量无setter方法
        request.setAttribute("pageBean", pageBean);
        
        //获取点击的状态
        int state = (int)session.getAttribute("state");
        System.out.println("---------状态="+state);
        
        List<Book> bookList=bookservice.queryBystate(state, user.getUserId(), pageBean);
        request.setAttribute("bookList", bookList);
        
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        
        
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
    }

}
