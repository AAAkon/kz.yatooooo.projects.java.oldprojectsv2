<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FIND</title>

<style>
	input{
		display:block;
		width:300px;
		background-color:black;
		color:white;
		font-size:24px;
		padding: 6px;
		margin:20px auto;
	}
	
	h1{
		text-align:center;
	}
</style>
</head>
<body>
	<h1>Form "Find User"</h1>
	<form method="get" action="find">
		<input name="id" type="number" min="0" placeholder="your id">
		<input type="submit" value="Find">
	</form>

	<br>
	<h3></h3>
	<input name="fname" type="text"	value="<%=request.getAttribute("fname") %>">
	<input name="lname" type="text" value="<%=request.getAttribute("lname") %>">
</body>
</html>