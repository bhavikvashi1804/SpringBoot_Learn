<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Hello ${name}</h1>
	
	<h2>
		<a href="\add-todo">Add To-Do</a>
	</h2>
	
	<h2>List of To-Do</h2>
	${todos}
	
</body>
</html>