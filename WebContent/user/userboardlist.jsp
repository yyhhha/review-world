<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>

<body class="w3-light-grey">

</body>
</head>

<div>
<jsp:include page="../common/header.jsp" />
</div>

<nav>
	<jsp:include page="../common/nav.jsp" />
</nav>

<!-- ***********************************************************  -->

<div style="padding: 20px 200px 20px 315px" class="w3-container">
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


		<form action="#" method="post">
			<c:forEach items="${requestScope.boardlistAllUser}" var="data">
				<tr>
					<td>${data.categoryName}</td>
					<td width="500">${data.title}</td>
					<td>${data.nickname}</td>
					<td>${data.likes}</td>
					<td>${data.views}</td>
					<td>${data.boardDate}</td>
					<td><input type="checkbox" name="del-id"
						value="${data.boardId}"></td>
				</tr>
				<input type="hidden" name="boardId" value="${data.boardId}">
			</c:forEach>
	</table>



	<div align="right">
		<button type="submit" class="w3-button w3-dark-grey" name="command"
			value="삭제">
			삭제하기 &nbsp;<i class="fa fa-trash-o"></i>

		</button>

	</div>
	</form>
	<br> <a href="admin/admincategoryupdate.jsp"><button
			type="submit" class="w3-button w3-dark-grey">
			카테고리 수정하러가기 &nbsp;<i class="fa fa-pencil"></i>
		</button></a>



</div>

<!-- ************************************************ -->

<footer>
	<jsp:include page="../common/footer.jsp" />
</footer>



</html>