package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import javax.management.RuntimeErrorException;

import com.book.entity.User;
import com.book.exception.DBException;

public class LoginDaoimpl implements LoginDao{
    
    

    

    @Override
    public User selectByName(String username) {
        // TODO Auto-generated method stub
        if(username==null || username.equals("")) {
            return null;
        }
        
        //1.获取连接对象
        Connection conn = mysql.getConn();
        PreparedStatement pstm = null;
        //准备sql语句
        String sql = "SELECT * FROM t_user WHERE user_name=?";
        ResultSet rs = null;
        User user = new User();
        try {
            
            //2.获取操作句柄
            pstm = conn.prepareStatement(sql);
            //3.得到结果集
            pstm.setString(1,username );
            rs = pstm.executeQuery();
    
            if(rs.next()) {     
                int id = rs.getInt("user_id");
                String nameDB = rs.getString("user_name");
                String passwordDB = rs.getString("user_password");
                String email = rs.getString("email");
                String apartment = rs.getString("apartment");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                Date createdTime = rs.getDate("created_time") ;
                Date updateTime = rs.getDate("update_time");
                Date lastLoginTime = rs.getDate("last_login_time");      
                int grade = rs.getInt("user_grade");
                user.setUserId(id);
                user.setUserPassword(passwordDB);
                user.setUserName(username);    
                user.setEmail(email);
                user.setApartment(apartment);
                user.setTel(tel);
                user.setAddress(address);
                user.setCreatedTime(createdTime);
                user.setUpdateTime(updateTime);
                user.setLastLoginTime(lastLoginTime);
                user.setUserGrade(grade);
                
            }
            System.out.println("数据库"+user);
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("有错误-------");
            e.printStackTrace();
            throw new DBException();
            
        }finally{
            mysql.close(conn, pstm, rs);
        }
          return user;
            
            
    }
    

}
