<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; ">
  <title>Login</title>
  <link href="${path}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
  <!--头部开始-->
  <div id="header">
      <div class="headerLeft">
          <div class="logo">
              <img class="logoImg" src="../image/logo.png" />
              <p class="logoTitle">Student Management System</p>
          </div>
      </div>
      <div class="headerRight">
          <a class="help" href="/a">帮助</a>
          <a class="review" href="/b">反馈</a>  
      </div>
  </div>
  <!--头部结束-->
  <!--中间部分开始-->
  <div id="main">
      <div id="mainCenter">
          <div class="ad"></div>
          <div class="loginDiv">
              <div class="loginModual">
                  <h2>用户登录</h2>
                  <form action="${path}/useroperation/checklogin.action" method="post" id="loginForm">
                      <div class="formDiv">
                      <div class="accountBox inputBox">
                          <div class="likeImage"></div>
                          <input name="userName" class="username" placeholder="Please enter the user name"/>
                          <span style="color:red">${UNErrorMessage} </span>
                      </div>
                      <div class="passwordBox inputBox">
                          <div class="pwdImage"></div>
                          <input type="password" name="password" class="password" placeholder="Please enter the password"/>
                          <span style="color:red">${PWDErrorMessage} </span>
                      </div>
                      
                      <div class="unLogin">
                          <input type="checkbox" />三天内免登陆
                          <a class="forgetPassword" href="/for">忘记密码？</a> 
                      </div>
                      <div class="loginBtnDiv">
                          <a href="javascript:document:loginForm.submit();">登录</a>
                      </div>
                      <div class="RegBtnDiv">
                          <a href="/">注册新账号</a>
                      </div>
                      </div>
                  </form>
              </div>  
          </div>
      </div>
  </div>
  <!--中间部分开始-->
  <div id="footer">

  </div>
  <!--中间部分结束-->   
  <script type="text/javascript" src="${path}/js/jQuery-3.3.1.js"></script>
  <script type="text/javascript" src="${path}/js/login.js"></script>
</body>
</html>