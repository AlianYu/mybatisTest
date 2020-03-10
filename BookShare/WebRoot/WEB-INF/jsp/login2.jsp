<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.Constants" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
  <head>
    
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="static/login.css" rel="stylesheet" type="text/css"/>

  </head>
  <script>
    function login() {
  
        var loginFormObj = document.getElementById("loginForm");
        var userNameValue = document.getElementById("userName").value;
        var passwordValue = document.getElementById("password").value; 
        var isSumbitForm = true;  
      	 //前端验证用户名和密码是否为空
        if(!userNameValue){//如果用户名为空，不要提交表单
        	var tipusername = document.getElementById("tipUserName").innerHTML="Username is required";
        	isSumbitForm=false;
        } else {
        	var tipusername = document.getElementById("tipUserName").innerHTML="";
        }
       
        if(!passwordValue){//如果用户名为空，不要提交表单
        	var tipusername = document.getElementById("tipPassword").innerHTML="Password is required";	
        	isSumbitForm=false;
        } else {
        	var tipusername = document.getElementById("tipPassword").innerHTML="";	
        } 
         if(isSumbitForm){
       		 loginFormObj.submit();
        }  
    }
  </script>
  <body>
 
   		<div class="mainDiv">
			
			<div class="leftDiv">
				
			</div>
			<div class="rightDiv">
				<div class="swithLoginTitleDiv">
					<a href="#e" id="tabOne">帐号登录</a> 
					<a href="#e" id="tabTwo">免密登录</a>
				</div>
				<div class="swithLoginWayDiv">
				
					<form action="login" method="post"  id="loginForm">
					用户名：<input type="text" name="userName" class="username" id="userName"/>
					 <span class = "tips_error" id="tipUserName">
					  <%  
					  String tipmessage1 =(String)request.getAttribute(Constants.TIP_MESSAGE);
					  if(tipmessage1 !=null && tipmessage1.equals("用户不存在[1000]") ){
					  	out.print(tipmessage1);
					  }
					   %>
					 </span>
					<br/><br/>
					密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name ="password" type="password" class="password" id="password"/>
					<span class = "tips_error" id="tipPassword">
					<%  
					  String tipmessage2 =(String)request.getAttribute(Constants.TIP_MESSAGE);
					  if(tipmessage2 !=null && tipmessage2.equals("密码错误[1001]")){
					  	out.print(tipmessage2);
					  }
					   %>
					</span><br/><br/>
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input type="button" value="登录" onclick="login()" id="loginBtn"/>
					</form>
				</div>
			</div>
			
			<div class="downDiv">
				
			</div>
		</div>
  </body>
</html>
