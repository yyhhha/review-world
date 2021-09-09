<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/findemail.css">

</head>
<body>
<h2>whogi Sign up Form</h2>
    <div class="container">
	    <form action="review" method="post">
		<input type="hidden" name="command" value="userInsert">
	      <label for="uid"><b>Id</b></label>
	      <input type="text" placeholder="Enter ID" name="uid" required>
	      <label for="psw"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="psw" required>
	      <label for="nickname"><b>Nickname</b></label>
	      <input type="text" placeholder="Enter NICKNAME" name="nickname" required>
	      <label for="email"><b>e-mail</b></label>
	      <input type="text" placeholder="Enter Your EMAIL" name="email" required>
	      
	      <button type="submit">sign up</button>
	     </form>
    </div>
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="location.href='login.jsp'" class="cancelbtn"> Cancel</button>
    </div>
  </form>
</div>

</body>
</html>