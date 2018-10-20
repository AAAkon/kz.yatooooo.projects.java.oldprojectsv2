<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<title>Profile</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/myprofile.css" %>
	<%@include file="/js/myprofile.js" %>
	
</head>
<body>
	<div class="container-fluids">
		<%@include file="/pageelements/navbarright.jsp" %>
		
		
	    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
		
			<%@include file="subpages/profile.profile.jsp" %>
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				
			</div>
		
		</div> 
	</div>		
</body>
</html>
<% } %>