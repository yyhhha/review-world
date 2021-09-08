<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html lang="ko">
<head>
<title>이메일로 회원찾기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/findemail.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!--이메일로 회원찾기 -->


</head>
<body>

<h2>Find </h2>

    <div class="container">
      
      
      <label for="USER_EMAIL"><b>USER_EMAIL</b></label>
      <input type="text" placeholder="Enter USER_EMAIL" name="USER_EMAIL" required>
     
      <button type="submit">Find</button>
      <label>
        
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="location.href='login.jsp'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

</body>
</html>