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
import com.book.entity.PageBean;
import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.BookServiceimpl;

public class KindOfServlet extends HttpServlet {
    
    //private BookService bookservice = new BookServiceimpl();
    private BookService bookservice = (BookService) BeanFactory.getInstance().getBean("bookService");
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页面参数
        String stateStr = request.getParameter("state");
        int state = Integer.parseInt(stateStr);
        System.out.println(state);
        
        HttpSession session = request.getSession();
        
        User user = (User)session.getAttribute("USER");
        int userId = user.getUserId();
        //获取数据库数量
        int count=bookservice.getBookCountByUserId(userId, state);
        
        
        //改变session中的状态state(用于更新切换tab之后的分页按钮)
        session.setAttribute("state", state);
        
        //准备pagebean
        PageBean pageBean = new PageBean();
        
        //初始化pageBean
        pageBean.setCurrentPage(1);//当前页数
        pageBean.setTotalcount(count);//总数量
        pageBean.setPagesize(5);//一页数目
        //总页数无setter方法,偏移量无setter方法
        request.setAttribute("pageBean", pageBean);
        //得到集合
        
        List<Book> bookList=bookservice.queryBystate(state, userId, pageBean);
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        
        
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post方式处理请求参数乱码
        //request.setCharacterEncoding("utf-8");
        doGet(request, response);

    }

}
