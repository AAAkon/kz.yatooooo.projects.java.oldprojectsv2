<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>registration page</title>
	
	<%@include file="pageelements/headerelements.jsp" %>
</head>
<body>

<div class="container-fluids" >
		<%@include file="pageelements/navbarright.jsp" %>
				
		<div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
			<div class="form-container">
				<h1>Registration Form:</h1><br>
				<form action="registration" method="post" enctype="multipart/form-data">
					<div class="form-group">
				    	<label for="files" class="btn btn-default btn-xs" id="image">Select Avatar Image</label>
  						<input id="files" style="visibility:hidden;" type="file" name="image" onchange="readURL(this);">
		    			<img id="avatar" src="#" alt="" />
				  	</div>
					<div class="form-group">
				    	<label for="name">Name:</label>
				    	<input type="text" class="form-control" name="name" required>
				 	</div>
				 	<div class="form-group">
				    	<label for="name">Surname:</label>
				    	<input type="text" class="form-control" name="surname" required> 
				 	</div>
				 	<div class="form-group">
				    	<label for="city">City:</label>
				    	<input type="text" class="form-control" name="city" required>
				  	</div>
				  	<div class="form-group">
				    	<label for="address">Address:</label>
				    	<input type="text" class="form-control" name="address" required>
				  	</div>
				  	<div class="form-group">
				    	<label for="phoneNo">Phone no:</label>
				    	<input type="text" class="form-control" name="phoneNo" maxlength="11" required>
				  	</div>
				  	<div class="form-group">
				    	<label for="email">Email address:</label>
				    	<input type="email" class="form-control" name="email" required>
				  	</div>
				  	<div class="form-group">
				    	<label for="login">Username:</label>
				    	<input type="text" class="form-control" name="username" required>
				  	</div>
				  <div class="form-group">
				    <label for="pwd">Password:</label>
				    <input type="password" class="form-control" name="password" required>
				  </div>
				  <div class="form-group">
				    <label for="pwd">Confirm password:</label>
				    <input type="password" class="form-control" name="password2" required>
				  </div>
				  				  
				  <button type="submit" class="btn btn-primary">Sing up</button>
				</form>
			</div>
		</div>
</div>

</body>
</html>


<!-- JavaScript -->
<%@include file="/js/registration.js"%>

<!-- CSS -->
<%@include file="/css/registration.css"%>