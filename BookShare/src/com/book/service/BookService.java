package com.book.service;

import java.util.ArrayList;
import java.util.List;

import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.exception.ParaException;

public interface BookService {
    int save(Book book) throws ParaException;
    
    //查找某用户全部图书
    ArrayList<Book> selectbyId(int userId);
    
    //查找用户所有图书的数量
    int getBookCountByUserId(int userId,int state);
    
    //按用户分页查询书
    List<Book> query(int userId,PageBean pageBean);
    
    //根据状态查询某用户的图书并分页处理
    List<Book> queryBystate(int state,int userId,PageBean pagebean);
}
