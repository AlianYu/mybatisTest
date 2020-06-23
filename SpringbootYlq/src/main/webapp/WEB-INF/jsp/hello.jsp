<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>hello</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
  <body>
    <form action="sumbit" method="post">
        用户名：<input name="username"/><br/>
     密码：<input name="password"/><br/>
     爱好：篮球<input name="hobby" value="篮球" type="checkbox"/>
     舞蹈<input name="hobby" value="舞蹈" type="checkbox"/>
     足球<input name="hobby" value="足球" type="checkbox"/>
     钢琴<input name="hobby" value="钢琴" type="checkbox"/>
     小提琴<input name="hobby" value="小提琴" type="checkbox"/>
     古筝<input name="hobby" value="古筝" type="checkbox"/>
     <br/>
     <input type="submit" value="提交"/> 
    </form>
    
    
  </body>
</html>
