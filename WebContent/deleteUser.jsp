<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- http://localhost/step12_reviewSite/login.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/findemail.css">
<title>login</title>
</head>
<body>
<h2>whogi Delete Form</h2>
    <div class="container">
    	<form action="review" method="post">
    	<input type="hidden" name="command" value="deleteUser">
      <label for="uid"><b>User Id</b></label>
      <input type="text" placeholder="Enter Username" name="uid" required>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <button type="submit">Delete User</button>
      </form>
    </div>
    <div class="container" style="background-color:#f1f1f1">
       <button type="button" onclick="location.href='login.jsp'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

</body>
</html>