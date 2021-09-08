<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% 	
	String url = application.getContextPath() + "/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/findemail.css">
<title>유저 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>유저</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>user id</th><th>pw</th><th>닉네임</th>
	</tr>
 	<tr>
 		<td>${requestScope.user.userId}</td>
 		<td>${requestScope.user.userPw}</td>
 		<td>${requestScope.user.nickName}</td>
 		
 	</tr>
</table>
<br><br><br>
	<div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="location.href='login.jsp'" class="cancelbtn"> login</button>
    </div>
</center>
</body>
</html>







