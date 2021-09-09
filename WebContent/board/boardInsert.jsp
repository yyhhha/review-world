<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/boardinsert.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<title>게시글 작성</title>
</head>
<body class="w3-theme-l5">

<form action="${pageContext.request.contextPath}/review?command=boardInsert" method="post">
<div class="w3-container">
 	  <p contenteditable="true" style="font-size:30px"><b>제목</b></p>
 	  <h5><span class="w3-opacity">April 7, 2014</span></h5>
      <select name="category">
			<option value="c1">자유</option>
			<option value="c2">영화</option>
			<option value="c3">맛집</option>
			<option value="c4">게임</option>
			<option value="c5">IT/테크</option>
	  </select> 
    </div>
    <div class="w3-container">
      <p contenteditable="true" class="w3-border w3-padding" style="font-size:15px">내용<br><br><br><br><br><br></p>
      <div class="w3-row">
        <div class="w3-col m8 s12">
          <p><button type="submit" class="w3-button w3-padding-large w3-white w3-border"><b>post &raquo;</b></button></p>
        </div>
        <div class="w3-col m4 w3-hide-small">
        </div>
      </div>
    </div>
 </form>
	
<br><br><br>

</body>
</html>

<%-- 

http://ip:port/project/board/boardinsert.jsp
http://ip:port/project/review
 --%>

<%-- <form action="${pageContext.request.contextPath}/review?command=boardInsert" method="post">
	<div id="editor">
	<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px"> 
		<div class="w3-col m7">
	      <div class="w3-row-padding">
	        <div class="w3-col m12">
	          <div class="w3-card w3-round w3-white">
	            <div class="w3-container w3-padding">
	              <p contenteditable="true" class="w3-border w3-padding" name="title">제목을 입력해주세요</p>
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
</form>  --%>