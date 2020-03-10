package com.book.entity;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class User {
    public int userId;
    public String userName;
    public String userPassword;
    public String email;
    public String apartment;
    public String tel;
    public String address;
    public Date createdTime;
    public Date updateTime;
    public Date lastLoginTime;
    public int userGrade;

    

    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public User() {
        super();
    }
    public User(int userId, String userName, String userPassword, String email, String apartment, String tel,
            String address, Date createdTime, Date updateTime, Date lastLoginTime, int userGrade) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        this.apartment = apartment;
        this.tel = tel;
        this.address = address;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
        this.userGrade = userGrade;
    }
    
    
    
    
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        
        this.createdTime = createdTime;
        
        
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        
    }
    public int getUserGrade() {
        return userGrade;
    }
    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", email="
                + email + ", apartment=" + apartment + ", tel=" + tel + ", address=" + address + ", createdTime="
                + createdTime + ", updateTime=" + updateTime + ", lastLoginTime=" + lastLoginTime + ", userGrade="
                + userGrade + "]";
    }
    
    
    
    

}
