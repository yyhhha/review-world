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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>유저 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

<%-- ${session.getAttribute("successMsg")}--%>
<h2>${sessionScope.successMsg}</h2>

<hr><p> 
 <div class="container">
	<table class="table table-striped">
	<thead>
		<tr>
			<th>user id</th><th>pw</th><th>닉네임</th><th>Email</th>
		</tr>
		</thead>
		<tbody>
	 	<tr>
	 		<!--  <td>${requestScope.user.userId}</td>
	 		<td>${requestScope.user.userPw}</td>
	 		<td>${requestScope.user.nickName}</td>
	 		<td>${requestScope.user.userEmail}</td> -->
	 		
	 		<%-- <td><%session.getAttribute("id");%></td>
	 		<td><%session.getAttribute("pw");%></td>
	 		<td><%session.getAttribute("nickName");%></td>
	 		<td><%session.getAttribute("email");%></td> 
	 		--%>
	 		<td>${sessionScope.id}</td>
	 		<td>${sessionScope.pw}</td>
	 		<td>${sessionScope.nickName}</td>
	 		<td>${sessionScope.email}</td>
	 	</tr>
	 	</tbody>
	</table>
</div>
	<%
		session.invalidate();
		session = null;
	%>
<br><br><br>
	<div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="location.href='../login.jsp'" class="cancelbtn"> login</button>
    </div>
</center>
</body>
</html>







