package com.book.service;

import java.util.ArrayList;
import java.util.List;

import com.book.common.BeanFactory;
import com.book.dao.EditBookdao;
import com.book.dao.EditBookdaoimpl;
import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.exception.ParaException;

public class BookServiceimpl implements BookService{
    
    //private EditBookdao bookdao = new EditBookdaoimpl();

    private EditBookdao bookdao = (EditBookdao) BeanFactory.getInstance().getBean("editBookdao");
    
    //IOC/DI的方式创建对象
//    private EditBookdao bookdao;
//    
//    
//
//    public void setEditBookdao(EditBookdao bookdao) {
//        this.bookdao = bookdao;
//    }

    
    
    @Override
    public int save(Book book) throws ParaException {
        // TODO Auto-generated method stub
        ParaException parameterException = new ParaException();
        
        if(book.getAuthor()==null || book.getAuthor().equals("") ) {
            parameterException.addErrorField("AuthorERROR", "Author is required");
            
        }
        if(book.getBookName()==null || book.getBookName().equals("") ) {
            parameterException.addErrorField("BookNameERROR", "BookName is required");
            
        }
        if(book.getDescription()==null || book.getDescription().equals("") ) {
            parameterException.addErrorField("DescriptionERROR", "Description is required");
            
        }
        bookdao.insertBook(book);
        return book.getBookId();
    }

    @Override
    public ArrayList<Book> selectbyId(int userId) {
        // TODO Auto-generated method stub
        
        return bookdao.selectbyId(userId);
    }

    @Override
    public int getBookCountByUserId(int userId,int state) {
        // TODO Auto-generated method stub
        return bookdao.getBookCountByUserId(userId,state);
    }

    @Override
    public List<Book> query(int userId, PageBean pageBean) {
        // TODO Auto-generated method stub
        return bookdao.query(userId, pageBean);
    }

    @Override
    public List<Book> queryBystate(int state, int userId, PageBean pagebean) {
        // TODO Auto-generated method stub
        return bookdao.queryBystate(state, userId, pagebean);
    }

}
