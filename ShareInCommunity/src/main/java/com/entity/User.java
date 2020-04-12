package com.entity;

import java.util.Date;

public class User {

    private int userId;
    private String userName;
    private String userPwd;
    private String userTel;
    private int userGrade;
    private float userBalance;
    private Date userRegtime;
    private Date userLogofftime;

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
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserTel() {
        return userTel;
    }
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
    public int getUserGrade() {
        return userGrade;
    }
    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }
    public float getUserBalance() {
        return userBalance;
    }
    public void setUserBalance(float userBalance) {
        this.userBalance = userBalance;
    }
    public Date getUserRegtime() {
        return userRegtime;
    }
    public void setUserRegtime(Date userRegtime) {
        this.userRegtime = userRegtime;
    }
    public Date getUserLogofftime() {
        return userLogofftime;
    }
    public void setUserLogofftime(Date userLogofftime) {
        this.userLogofftime = userLogofftime;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userTel=" + userTel
                + ", userGrade=" + userGrade + ", userBalance=" + userBalance + ", userRegtime=" + userRegtime
                + ", userLogofftime=" + userLogofftime + "]";
    }

}
