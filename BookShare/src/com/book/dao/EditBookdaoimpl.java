package com.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.book.entity.Book;
import com.book.entity.PageBean;
import com.book.exception.DBException;

public class EditBookdaoimpl implements EditBookdao {

    @Override
    public int insertBook(Book book) {
        // TODO Auto-generated method stub
        if(book==null || book.equals("")){
            return -1;
        }
        //1.获取连接对象
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //准备sql语句
        String sql ="INSERT INTO book \r\n" + 
                "(book_name,"
                + "picture,"
                + "owner_id,"
                + "current_owner_id,"
                + "author,description,"
                + "created_time,update_time) \r\n" + 
                "VALUES (?,?,?,?,?,?,NOW(),NOW())";
        try {
            System.out.println("获取id");
            pstm=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, book.getBookName());
            pstm.setString(2, book.getPicture());
            pstm.setInt(3, book.getOwnerId());
            pstm.setInt(4, book.getCurrentOwnerId());
            pstm.setString(5, book.getAuthor());
            pstm.setString(6, book.getDescription());
            System.out.println("获取id");
            pstm.executeUpdate();
            
            rs= pstm.getGeneratedKeys();
            
            if(rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
                book.setBookId(id);
            }
            
            
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            
            e.printStackTrace();
            throw new DBException();
        }
        finally{
            mysql.close(conn, pstm, rs);
        }
        return 1;
    }

    @Override
    public ArrayList<Book> selectbyId(int userId) {
        // TODO Auto-generated method stub
        
        //1.获取连接对象
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<Book>  bookList = new ArrayList<Book>();
        
        //准备sql语句
        String sql ="SELECT * FROM book WHERE owner_id="+userId+" ORDER BY book_id DESC";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                int bookId = rs.getInt("book_id");
                String bookName = rs.getString("book_name");
                String picture = rs.getString("picture");
                int ownerId = rs.getInt("owner_id");
                int currentOwnerId = rs.getInt("current_owner_id");
                String author = rs.getString("author");
                String description = rs.getString("description");
                Date createdTime = rs.getDate("created_time");
                Date updateTime = rs.getDate("update_time");
                
                book.setBookId(bookId);
                book.setBookName(bookName);
                book.setPicture(picture);
                book.setOwnerId(ownerId);
                book.setCurrentOwnerId(currentOwnerId);
                book.setAuthor(author);
                book.setDescription(description);
                book.setCreatedTime(createdTime);
                book.setUpdateTime(updateTime);
                bookList.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            mysql.close(conn, pstm, rs);
        }
        
        
        return bookList;
    }

    @Override
    public int getBookCountByUserId(int userId,int state) {
        // TODO Auto-generated method stub
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        //准备sql语句
        String sql ="";
        if(state==1) {
             sql ="SELECT COUNT(*) AS allcount FROM book WHERE owner_id="+userId;
        }else if (state==2){
            sql="SELECT COUNT(*) AS allcount FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id != book.current_owner_id AND book.owner_id = u.user_id AND u.user_id="+userId;
        }else if(state==3) {
            sql ="SELECT COUNT(*) AS allcount FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id = book.current_owner_id AND book.owner_id = u.user_id AND u.user_id="+userId;
        }else if(state==4) {
            sql="SELECT COUNT(*) AS allcount FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id != book.current_owner_id AND book.owner_id != u.user_id AND u.user_id="+userId;
        }
        
        int count=-1;
        try {
            pstm= conn.prepareStatement(sql);
            rs= pstm.executeQuery();
            if(rs.next()) {
                count = rs.getInt("allcount");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            mysql.close(conn, pstm, rs);
        }

        return count;
    }

    @Override
    public List<Book> query(int userId, PageBean pageBean) {
        // TODO Auto-generated method stub
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<Book>();
        //准备sql语句
        String sql ="SELECT * FROM book WHERE owner_id ="+userId+" ORDER BY book_id DESC LIMIT "+pageBean.getOffset()+","+pageBean.getPagesize()+"";
        try {
            pstm=conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                int bookId = rs.getInt("book_id");
                String bookName = rs.getString("book_name");
                String picture = rs.getString("picture");
                int ownerId = rs.getInt("owner_id");
                int currentOwnerId = rs.getInt("current_owner_id");
                String author = rs.getString("author");
                String description = rs.getString("description");
                Date createdTime = rs.getDate("created_time");
                Date updateTime = rs.getDate("update_time");
                
                book.setBookId(bookId);
                book.setBookName(bookName);
                book.setPicture(picture);
                book.setOwnerId(ownerId);
                book.setCurrentOwnerId(currentOwnerId);
                book.setAuthor(author);
                book.setDescription(description);
                book.setCreatedTime(createdTime);
                book.setUpdateTime(updateTime);
                bookList.add(book);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return bookList;
    }

    @Override
    public List<Book> queryBystate(int state, int userId, PageBean pagebean) {
        // TODO Auto-generated method stub
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<Book>();
        //准备sql语句
        
        String sql ="";
        if(state==1) {
            sql ="SELECT * FROM book WHERE owner_id ="+userId+" ORDER BY book_id DESC LIMIT "+pagebean.getOffset()+","+pagebean.getPagesize()+"";
        }else if(state==2) {
            sql = "SELECT * FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id != book.current_owner_id AND book.owner_id = u.user_id AND u.user_id="+userId+"\r\n" + 
                    "ORDER BY book_id DESC LIMIT " +pagebean.getOffset()+","+pagebean.getPagesize()+"";
            
        }else if(state==3) {
            sql = "SELECT * FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id = book.current_owner_id AND book.owner_id = u.user_id AND u.user_id="+userId+"\r\n" + 
                    "ORDER BY book_id DESC LIMIT " +pagebean.getOffset()+","+pagebean.getPagesize()+"";
        }else if(state==4) {
            sql = "SELECT * FROM book JOIN t_user u ON book.owner_id=u.user_id \r\n" + 
                    "WHERE book.owner_id != book.current_owner_id AND book.owner_id != u.user_id AND u.user_id="+userId+"\r\n" + 
                    "ORDER BY book_id DESC LIMIT " +pagebean.getOffset()+","+pagebean.getPagesize()+"";
        }
        
        
        try {
            pstm=conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                int bookId = rs.getInt("book_id");
                String bookName = rs.getString("book_name");
                String picture = rs.getString("picture");
                int ownerId = rs.getInt("owner_id");
                int currentOwnerId = rs.getInt("current_owner_id");
                String author = rs.getString("author");
                String description = rs.getString("description");
                Date createdTime = rs.getDate("created_time");
                Date updateTime = rs.getDate("update_time");
                
                book.setBookId(bookId);
                book.setBookName(bookName);
                book.setPicture(picture);
                book.setOwnerId(ownerId);
                book.setCurrentOwnerId(currentOwnerId);
                book.setAuthor(author);
                book.setDescription(description);
                book.setCreatedTime(createdTime);
                book.setUpdateTime(updateTime);
                bookList.add(book);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return bookList;
        
    }

}
