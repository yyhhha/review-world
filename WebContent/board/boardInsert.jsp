<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/boardinsert.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<title>게시글 작성</title>
</head>
<body class="w3-theme-l5">

<h2>게시글 작성</h2>

<form action="review?command=boardInsert" method="post">
	<div id="editor">
	<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px"> 
		<div class="w3-col m7">
	      <div class="w3-row-padding">
	        <div class="w3-col m12">
	          <div class="w3-card w3-round w3-white">
	            <div class="w3-container w3-padding">
	              <p contenteditable="true" class="w3-border w3-padding">제목을 입력해주세요</p>
	              <hr>
	              <p contenteditable="true" class="w3-border w3-padding">내용을 입력해주세요<br><br><br><br><br><br><br></p>
	              <button type="submit" class="w3-button w3-theme">Post</button> 
	            </div>
	          </div>
	        </div>
	      </div>
		</div>
    </div>
    </div>
</form>
	
<br><br><br>

</body>
</html>