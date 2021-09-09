<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/boarddetail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<title>게시글 확인</title>
</head>
<body class="w3-theme-l5">

	<div class="w3-container">
      <h3><b>제목 ${requestScope.title}</b></h3>
      <h5>카테고리${requestScope.category}, <span class="w3-opacity">April 7, 2014</span></h5>
    </div>

    <div class="w3-container">
      <p>내용 ${requestScope.content}</p>
      <div class="w3-row">
        <div class="w3-col m8 s12">
          <p><button class="w3-button w3-padding-large w3-white w3-border" onclick="location.href='${pageContext.request.contextPath}/reviewz?command=boardlistAll'"><b>list &raquo;</b></button>
          <button class="w3-button w3-padding-large w3-white w3-border" onclick="location.href='${pageContext.request.contextPath}/reviewz?command=boardUpdate'"><b>edit &raquo;</b></button>
          <button class="w3-button w3-padding-large w3-white w3-border" onclick="location.href='${pageContext.request.contextPath}/reviewz?command=boardDelete'"><b>delete &raquo;</b></button>
          </p>
        </div>
        <div class="w3-col m4 w3-hide-small">
          <p><span class="w3-padding-large w3-right"><b>Comments &nbsp;</b> <span class="w3-tag">0</span></span></p>
        </div>
      </div>
    </div>

<%-- <c:if test="${not empty requestScope.board}">
	<table border="1">
		<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>
		
		<c:forEach items="" var="dto">
				<tr>
					<td>${dto.deptno}</td> 
					<td>${dto.dname}</td>
					<td>${dto.loc}</td>
				</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${empty sessionScope.all}">
	별도의 부서가 없는 회사입니다.
</c:if>	 --%>

<%-- <form action="reviewZ?command=boardInsert" method="post">
	<div id="editor">
	<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px"> 
		<div class="w3-col m7">
	      <div class="w3-row-padding">
	        <div class="w3-col m12">
	          <div class="w3-card w3-round w3-white">
	            <div class="w3-container w3-padding">
	              <p contenteditable="true" class="w3-border w3-padding" name="title">${ }</p>
	              <hr>
	              <p contenteditable="true" class="w3-border w3-padding" name="content">내용을 입력해주세요<br><br><br><br><br><br><br></p>
	              <button type="submit" class="w3-button w3-theme">Post</button> 
	            </div>
	          </div>
	        </div>
	      </div>
		</div>
    </div>
    </div>
</form> --%>
	
<br><br><br>

</body>
</html>