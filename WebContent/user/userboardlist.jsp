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

<div style="padding: 20px 200px 20px 315px" class="w3-container">
	<h5>게시글 목록</h5>
	<table
		class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
		<tr align="center">
			<td width="150" style="text-align:center"><b>카테고리</b></td>
			<td width="700" style="text-align:center"><b>제목</b></td>
			<td width="200" style="text-align:center"><b>작성자</b></td>
			<td style="text-align:center"><b>추천수</b></td>
			<td style="text-align:center"><b>조회수</b></td>
			<td style="text-align:center"><b>작성일</b></td>
		</tr>

		<c:forEach items="${requestScope.boardlistAllUser}" var="data">
			<tr>
				<td style="text-align:center">${data.categoryName}</td>
				<td><a
					href="${pageContext.request.contextPath}/review?command=boardDetail&boardId=${data.boardId}">${data.title}</a></td>
				<td>${data.nickname}</td>
				<td style="text-align:center">${data.likes}</td>
				<td style="text-align:center">${data.views}</td>
				<td style="text-align:center">${data.boardDate}</td>
			</tr>
		</c:forEach>
	</table>

	<div align="right">
		<form action="${pageContext.request.contextPath}/board/boardwrite.jsp">
			<button type="submit" class="w3-button w3-dark-grey">글쓰기</button>
		</form>
	</div>

</div>

<footer>
	<jsp:include page="../common/footer.jsp" />
</footer>

</html>