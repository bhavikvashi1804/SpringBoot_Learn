<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo's for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it done?</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="oneTodo">
					<tr>
						<td>${oneTodo.desc}</td>
						<td>${oneTodo.targetDate}</td>
						<td>${oneTodo.done}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${oneTodo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${oneTodo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<a type="button" class="btn btn-primary" href="/add-todo">Add To-Do</a>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>