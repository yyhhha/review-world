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
<h2>whogi Login Form</h2>
    <div class="container">
    	<form action="review" method="post">
    	<input type="hidden" name="command" value="userLogin">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <button type="submit">Login</button>
      </form>
      <button type="button" onclick="location.href='signin.jsp'">sign in</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <button type="button" onclick="location.href='deleteUser.jsp'" class="cancelbtn">Delete</button>
      <span class="psw">Forgot <a href="findUserEmail.jsp">password?</a></span>
    </div>
  </form>
</div>

</body>
</html>