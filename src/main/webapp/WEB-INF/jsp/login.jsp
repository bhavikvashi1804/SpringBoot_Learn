<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<div>
		<h2 style="color: red">
			${msg}
		</h2>
	</div>
	<form method="post">
		Username : <input type="text" name="name"> <br>
		<br> Password : <input name="password" type="password"> <br>
		<br> <input type="submit">
	</form>
</body>
</html>