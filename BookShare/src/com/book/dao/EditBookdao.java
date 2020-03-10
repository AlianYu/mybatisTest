package com.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.book.entity.Book;
import com.book.entity.PageBean;

public interface EditBookdao {
    
    //新增图书
    int insertBook(Book book);
    
    //查找某用户全部图书
    ArrayList<Book> selectbyId(int userId);
    
    //查找用户所有图书的数量
    int getBookCountByUserId(int userId,int state);
    
    //按用户分页查询书
    List<Book> query(int userId,PageBean pageBean);
    
    
    //根据状态查询某用户的图书并分页处理
    List<Book> queryBystate(int state,int userId,PageBean pagebean);
    

}
