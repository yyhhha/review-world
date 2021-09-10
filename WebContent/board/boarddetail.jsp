<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="review.model.dto.UserDTO, review.model.dto.BoardDTO"%>
<%
	UserDTO user = (UserDTO)session.getAttribute("user");
	String id = user.getUserId();
	BoardDTO board = (BoardDTO) request.getAttribute("board");
	String bId = board.getUserId();
	int boardId = board.getBoardId();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<title>게시글 확인</title>
</head>

<body class="w3-light-grey">
	<div>
		<jsp:include page="../common/header.jsp" />
	</div>
	<nav>
		<jsp:include page="../common/nav.jsp" />
	</nav>
<body class="w3-theme-l5">
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

		<div class="w3-col l8 s12">
			<div class="w3-container w3-white w3-margin w3-padding-large">
				<div class="w3-center">
					<h3>${requestScope.board.title}</h3>
					<h5>
						${requestScope.board.categoryName}, <span class="w3-opacity">${requestScope.board.boardDate}</span>
					</h5>
				</div>

				<div class="w3-justify">
					<p style="margin: 70px 70px 70px 100px">
						${requestScope.board.content}</p>
					<p class="w3-center">
						<button class="w3-button w3-padding-large w3-white w3-border"
							onclick="${pageContext.request.contextPath}/review?command=boardlistAllUser'">
							<b>list &raquo;</b>
						</button>
					<%
						if (id.equals(bId)) {
					%>
					<form action="${pageContext.request.contextPath}/review">
						<p class="w3-center">
							<button class="w3-button w3-padding-large w3-white w3-border"
								type="submit">
								<b>delete &raquo;</b>
							</button>
						</p>
						<input type="hidden" name="command" value="boardDelete"> <input
							type="hidden" name="boardId" value="<%=boardId%>">
					</form>
					<%
						}
					%>
					</p>
				</div>
			</div>
		</div>
	</div>


	<script>
		// Get the Sidebar
		var mySidebar = document.getElementById("mySidebar");

		// Get the DIV with overlay effect
		var overlayBg = document.getElementById("myOverlay");

		// Toggle between showing and hiding the sidebar, and add overlay effect
		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
				overlayBg.style.display = "none";
			} else {
				mySidebar.style.display = 'block';
				overlayBg.style.display = "block";
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
			overlayBg.style.display = "none";
		}
	</script>
</body>
</html>