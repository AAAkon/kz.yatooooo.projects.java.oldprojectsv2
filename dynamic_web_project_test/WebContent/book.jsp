<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
<style>
	.form{
		width: 30%;
		float: left;
	}
	
	.table{
		width: 70%;
		float: left;
	}
</style>
</head>
<body>
	<div class="form">
		<form action="books" method="post">
			<h2>Book Form</h2>
			Name<br>
			<input type="text" name="name"><br><br>
			Author<br>
			<input type="text" name="author"><br><br>
			Page number<br>
			<input type="number" min="1" name="page_number"><br><br>
			Date<br>
			<input type="date" name="date"><br><br>
			<button type="submit">ADD+</button>
		</form>
	</div>
	<div class="table">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Page number</th>
				<th>Published date</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><c:out value="${book.name}"/></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.page_number}"/></td>
					<td><c:out value="${book.date}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>