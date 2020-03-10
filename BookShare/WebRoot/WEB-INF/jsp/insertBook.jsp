<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();

%>

<!DOCTYPE HTML PUBLIC >
<html>
  <head>
   
    
    <title>insert book</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link href="static/insertbook.css" rel="stylesheet" type="text/css"/>
  </head>
   <script>
    function insert() {
  
        var insertBookFormObj = document.getElementById("insertBookForm");
        
        var bookNameValue = document.getElementById("bookName").value;
        var authorValue = document.getElementById("author").value; 
        var descriptionValue = document.getElementById("description").value; 
       
        var isinsertBookForm = true;  
      	 //前端验证书名、作者、简介是否为空
        if(!bookNameValue){//如果书名为空，不要提交表单
        	var error_booknameValue = document.getElementById("error_bookname").innerHTML="bookname is required";
        	isinsertBookForm=false;
        } else {
        	var error_booknameValue = document.getElementById("error_bookname").innerHTML="";
        }
       
        if(!authorValue){//如果作者为空，不要提交表单
        	var error_authorValue = document.getElementById("error_author").innerHTML="author is required";	
        	isinsertBookForm=false;
        } else {
        	var error_authorValue = document.getElementById("error_author").innerHTML="";	
        } 
        
        if(!descriptionValue){//如果描述为空，不要提交表单
        	var descriptionValue = document.getElementById("error_description").innerHTML="description is required";	
        	isinsertBookForm=false;
        } else {
        	var descriptionValue = document.getElementById("error_description").innerHTML="";	
        } 
         if(isinsertBookForm){
       		 insertBookFormObj.submit();
        }  
    }
    </script>
  <body>
  
    <div class="mainDiv">
			<div class="up">
				<div class="logo">这里是logo</div>
				<div class="tabOne">
					<ul>
						<li><a>我的图书</a></li>
						<li><a>全部图书</a></li>
					</ul>
				</div>
				<div class="tabTwo">这是tool部分</div>
			</div>
			<div class="middle">
			<p>我的位置: 我的图书 > 新增图书</p>
				<!--上传图书封面照片开始-->
				<form action="<%=request.getContextPath() %>/editbook.action" method="post" id="insertBookForm">
				<div id="uploadimgDiv">
					1.上传图书封面照片
					<img  />
				</div>
				<!--上传图书封面照片结束-->
				
				<!--上传图书资料开始-->
				<div id="uploadziliaoDiv">
					2.填写书籍资料
					<input type="hidden" value="${USER.userId }" name="userId">
					<br/>	书名：<input name="bookName" class="bookName" id="bookName"/><span id="error_bookname"> </span>
					<br/>	作者：<input name="author" class="author" id="author" /><span id="error_author"> </span>
					<br/>	简介：<textarea name="description" id="description"></textarea><span id="error_description"> </span><br/>	
					
					<br/>
					<input type="button" value="提交" onclick="insert()" />
					</form>
				</div>
				<!--上传图书资料结束-->
			</div>
			<div class="down">
				
			</div>
			
		</div>
  </body>
</html>
