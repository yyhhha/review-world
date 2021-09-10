<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="review.model.dto.UserDTO"%>
<%
	UserDTO user = (UserDTO)session.getAttribute("user");
	String id = user.getUserId();
	String nickName = user.getNickName();
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
		<jsp:include page="/common/header.jsp" />
	</div>
	<nav>
		<jsp:include page="/common/nav.jsp" />
	</nav>

	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<div class="w3-col l8 s12">
			<div class="w3-container w3-white w3-margin w3-padding-large">
				<form action="${pageContext.request.contextPath}/review"
					method="post">
					<input type="hidden" name="command" value="boardInsert">
					<br>
					<div class="w3-center">
						<!-- <p contenteditable="true" style="font-size: 25px" id="title">
							<label for="title"><b>제목</b></label>
						</p> -->
						<input type="text" placeholder="제목을 입력하세요" name="title" required>
						<select name="category">
							<option value="c1">자유</option>
							<option value="c2">영화</option>
							<option value="c3">맛집</option>
							<option value="c4">게임</option>
							<option value="c5">IT/테크</option>
							<option value="c6">유영훈남</option>
						</select> 
					</div>
					<br>
					<br>
					<div class="w3-justify">
						<div class="w3-center">
							<input type="text" style="width:300px;height : 200px" placeholder="내용을 입력하세요" name="content"
								required>
						</div>
						<p class="w3-right">
							<button type="submit"
								class="w3-button w3-padding-large w3-white w3-border">
								<b>post &raquo;</b>
							</button>
							<input type="hidden" name="userId" value="<%=id%>">
							<input type="hidden" name="nickName" value="<%=nickName%>">
					</div>
				</form>
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