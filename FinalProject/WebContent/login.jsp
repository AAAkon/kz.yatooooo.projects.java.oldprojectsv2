<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login</title>
	<%@include file="/pageelements/headerelements.jsp" %>
</head>
<body>



<div class="container-fluids">

	<%@include file="pageelements/navbarright.jsp" %>
	
	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
		<div class="form-container">
			<h1>Login Form:</h1><br>
			<form action="login" method="post">
			  	<div class="form-group">
			    	<label for="username">Username:</label>
			    	<input type="text" class="form-control" name="username">
			  	</div>
			  <div class="form-group">
			    <label for="pwd">Password:</label>
			    <input type="password" class="form-control" name="password">
			  </div>
			  <button type="submit" class="btn btn-success">Sing in</button>
			</form>
		</div>
	</div>	
</div>

</body>
</html>