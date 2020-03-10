package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.BeanFactory;
import com.book.entity.Book;
import com.book.entity.User;
import com.book.exception.ParaException;
import com.book.service.BookService;
import com.book.service.BookServiceimpl;

public class EditBookServlet extends HttpServlet {
    
    //private BookService bookservice = new BookServiceimpl();
    private BookService bookservice = (BookService) BeanFactory.getInstance().getBean("bookService");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/insertBook.jsp").forward(request, response);
        
        
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post方式处理请求参数乱码
        //request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String userIdStr = request.getParameter("userId");
        System.out.println(bookName+"--"+author+"--"+description+"----"+userIdStr);
        int userId = Integer.parseInt(userIdStr);
        
        
        Book book = new Book();
        try {
            
            
            
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            System.out.println(user);
            book.setAuthor(author);
            book.setBookName(bookName);
            book.setDescription(description);
            book.setCurrentOwnerId(userId);
            book.setOwnerId(userId);
            book.setPicture("/0000000/"+userId);
            int bookId = bookservice.save(book);
            System.out.println("EditBookServlet-----bookId="+bookId);
            session.setAttribute("SUCCESS_MESSAGE", "新增图书成功");
            response.sendRedirect(request.getContextPath()+"/dashboard.action");
            
        } catch (ParaException e) {
            // TODO Auto-generated catch block
            Map<String, String> errormap = e.getErrormap();
            request.setAttribute("errormap", errormap);
            request.getRequestDispatcher("/WEB-INF/jsp/insertBook.jsp").forward(request, response);
            return ;
        }
                
    }

}
