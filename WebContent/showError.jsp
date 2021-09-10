<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String url = application.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>error</title>
</head>

<body>
	<br>
	<br>
	<br>

	<center>
		<h3>${requestScope.errorMsg}</h3>
		<h3>${sessionScope.errorMsg}</h3>
		<div class="w3-container" align="center">
			<br>
			<br> <img src="./images/error.png" alt="sorry"
				width="1071" height="803"> <br>
			<br>

		</div>
		<br>
		<br>
		<br> <a href="${pageContext.request.contextPath}/index.html">메인
			화면으로 이동하기</a>
		<%-- ${pageContext.request.contextPath}
			  프로젝트의 경로명을 담고 있음 --%>
	</center>



</body>
</html>