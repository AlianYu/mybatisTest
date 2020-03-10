<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.Constants" %>
<%
String path = request.getContextPath();

%>

<!DOCTYPE HTML>
<html>
  <head>
    
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <style>
  	.tips_error{
  		color:red;
  	}
  </style>
  <script>
    function login() {
  
        var loginFormObj = document.getElementById("loginForm");
        var userNameValue = document.getElementById("userName").value;
        var passwordValue = document.getElementById("password").value;
       /*  var isSumbitForm=true;  */
      	  /* //前端验证用户名和密码是否为空
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
        } */
        /*  if(isSumbitForm){
       		 loginFormObj.submit();
        }  */
         loginFormObj.submit();
        
        
    }
  </script>
  
  <body>
  <%  String tipmessage =(String)request.getAttribute(Constants.TIP_MESSAGE);
  if(tipmessage !=null){
  	out.print(tipmessage);
  }  
  Map<String, String> errormap = (Map<String, String>)request.getAttribute("errormap");
  if(errormap==null){
 	 errormap = new HashMap<String, String>();
  }
 
   %>
  
  
  
    <form action="login" method="post" id="loginForm" >
        User Name :<input type="text" name="userName" id="userName" />
        <span class = "tips_error" id="tipUserName">
        	<%
        	String usernameError = errormap.get("UserNameERROR")==null ? "" :errormap.get("UserNameERROR");
        	 out.print(usernameError);
        	 %>
        </span>
        
        <br/>
        Password :<input type="password" name="password" id="password" />
        <span class = "tips_error" id="tipPassword">
       <%
        	String PasswordERROR = errormap.get("PasswordERROR")==null ? "" :errormap.get("PasswordERROR");
        	 out.print(PasswordERROR);
        	 %>
        </span>
        
        </br>
        <input type="button" value="Login" onclick="login()" />
    </form>
  </body>
</html>
