<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo's for ${name}</title>
</head>
<body>
	<h1>Your To-Do</h1>
	<table>
		<caption>-:Your To-Do: -</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="oneTodo">
				<tr>
					<td>${oneTodo.desc}</td>
					<td>${oneTodo.targetDate}</td>
					<td>${oneTodo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>
		<a href="\add-todo">Add To-Do</a>
	</h2>

</body>
</html>