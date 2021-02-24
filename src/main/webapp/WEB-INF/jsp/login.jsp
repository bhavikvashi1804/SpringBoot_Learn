<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
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
</div>
<%@ include file="common/footer.jspf"%>