<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>회원목록 검색</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../adminCommon/main.css">

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

a {
	text-decoration: none
}
</style>
<body class="w3-light-grey">
</head>

<div>
	<jsp:include page="../adminCommon/header.jsp" />
</div>

<nav>
	<jsp:include page="../adminCommon/nav.jsp" />
</nav>

<!-- ************************************************ -->


<div style="padding: 20px 100px 20px 215px" class="w3-container">
	<h5>게시글 목록</h5>
	<table
		class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
		<tr align="center">
			<td width="100">카테고리</td>
			<td width="500">제목</td>
			<td>작성자</td>
			<td>추천수</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>선택</td>
		</tr>

	<<form action="#" method="post">
		<c:forEach items="${requestScope.boardlistAll}" var="data">
			<tr>
				<td>${data.categoryName}</td>
				<td width="500">${data.title}</td>
				<td>${data.nickname}</td>
				<td>${data.likes}</td>
				<td>${data.views}</td>
				<td>${data.boardDate}</td>
				<td><input type="checkbox" name="checkBoardId"></td>
			</tr>
		</c:forEach>

	</table>

	<br>
	<button class="w3-button w3-dark-grey">
		More Countries &nbsp;<i class="fa fa-arrow-right"></i>

	
<br>
<br>
	<button  type="submit" class="w3-button w3-dark-grey">
		수정하기 &nbsp;<i class="fa fa-arrow-right"></i>
	</button>

	<button type="submit" class="w3-button w3-dark-grey">
		삭제하기 &nbsp;<i class="fa fa-arrow-right"></i>

	</button>
</div>








<!-- ************************************************ -->

<footer>
	<jsp:include page="../adminCommon/footer.jsp" />
</footer>


<body>

</body>
</html>