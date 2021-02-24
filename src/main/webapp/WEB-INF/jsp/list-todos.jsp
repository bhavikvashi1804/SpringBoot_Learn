<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
					<td><fmt:formatDate value="${oneTodo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
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
		<a type="button" class="btn btn-primary" href="/add-todo">Add
			To-Do</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>

