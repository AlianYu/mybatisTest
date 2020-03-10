<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>

<%@ page import="com.book.entity.User" %>
<%@ page import="com.book.entity.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
%>

<!DOCTYPE HTML PUBLIC >
<html>
  <head>
    
    
    <title>Index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="static/index.css" rel="stylesheet" type="text/css"/>
	<link href="static/common.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="static/jQuery-3.3.1.js" ></script>
  
 
  </head>
  
  <body>
  
    <div class="mainDiv">
    <p>欢迎你！
				<% User user = (User)session.getAttribute("USER");
                   if(user !=null){
                   out.print(user.getUserName());	
                   %>
                  <span>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;创建时间： </span>
                   <% out.print(user.getCreatedTime());		
                   }
                   		
				%>
				</p>
				<!-- FlashMessage的显示和隐藏 -->
				<% String successFlashMessage = (String)session.getAttribute("SUCCESS_MESSAGE");
					successFlashMessage = successFlashMessage==null ? "" :successFlashMessage;
					String isDisplayFlashMessage = "";
					if(successFlashMessage.equals("")){
						isDisplayFlashMessage="style='display:none;'";
						
					}
				
				 %>
				<div id="successFlashMessage" <%=isDisplayFlashMessage %>>
				<%
					out.print(successFlashMessage);
					session.removeAttribute("SUCCESS_MESSAGE");
					if(!successFlashMessage.equals("")){
					%>
					<script type="text/javascript">
						var hideFlashMessage = function (){
							document.getElementById("successFlashMessage").style.display="none";
						}
						setTimeout(hideFlashMessage,3000);
					</script>
					<% 
					}
				 %>
				</div>
				
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
				<div class="left">
					<div class="leftPersonalListDiv">
						<p> 个人资料</p>
						<div id="photoDiv">
							<img  />
						</div>
						<ul id="ziliao">
							<li>部门：${USER.apartment }</li>
							<li>电话：${USER.tel }</li>
							<li>邮箱：${USER.email }</li>
							<li>地址：${USER.address }</li>
						</ul>
					</div>
					<div class="leftMessageDIV">
						<p> 我的消息</p>
					</div>
				</div>
				<div class="right">
					<div class="">
					<div id="div4">
						
						<div id="center">
							<ul id="ul1">
								<a href="${path}/kindof.action?state=1" ><li class="menu-li">全部(${pageBean.totalcount })</li></a>
								<a href="${path}/kindof.action?state=2" ><li class="menu-li">已借出(${kindbean.out })</li></a>
								<a href="${path}/kindof.action?state=3" ><li class="menu-li">未借出(${kindbean.in })</li></a>
								<a href="${path}/kindof.action?state=4" ><li class="menu-li">借入(${kindbean.borrewed })</li></a>
							</ul>
						</div>
						
						
					</div>
				</div>
				<!--右边内容开始-->
				<div class="content">
					 <table style ="width: 100%;">
						<thead>
							<tr>
								<th>编号</th><th>书籍</th><th>状态</th><th>操作</th><th>借阅历史</th>
							</tr>
							
						</thead>
						<tbody>
						
						<c:forEach items="${bookList}" var="book" begin="0" end="4" varStatus="statu">	
                  			<tr>
                  			
								<td id="number">${statu.index}</td><td>${book.bookName }</td>
								<td>
								 <c:choose>
				                    <c:when test="${book.ownerId==book.currentOwnerId}">
				                        <span class="do">未借出</span>
				                        
				                    </c:when>
				                     <c:when test="${book.ownerId!=book.currentOwnerId}">
				                        <span class="do">已借出</span>
				                    </c:when>
				                </c:choose>
								</td>
								<td>
								 <c:choose>
				                    <c:when test="${book.ownerId==book.currentOwnerId}">
				                       <button>更新</button>
				                       <button>删除</button>
				                    </c:when>
				                     <c:when test="${book.ownerId!=book.currentOwnerId}">
				                       
				                       <button>更新</button>
				                    </c:when>
				                </c:choose>
								</td>
								<td>zzzzzz</td>
							</tr>
							
							
                		</c:forEach>
							
							
						</tbody>
					</table>
				<div class="pageBox">
					<span><a href="${path}/bookpage.action?currentPage=1">&lt;&lt;</a></span>
					<span><a href="${path}/bookpage.action?currentPage=${pageBean.currentPage-1}">&lt;</a></span>
					<span>第${pageBean.currentPage}页</span>
					<span><a href="${path}/bookpage.action?currentPage=${pageBean.currentPage+1}">&gt;</a></span>
					<span><a href="${path}/bookpage.action?currentPage=${pageBean.pagecount}">&gt;&gt;</a></span>
					<span>去第<input type="text"/>页</span>
					
				</div>
  </body>
				</div>
				<!--右边内容结束-->	
				</div>
				
			</div>
			<div class="down">
				<a href="editbook.action" target="_blank" >新增图书</a>
				
				
			</div>
			
		</div>
		
  </body>
   
</html>
