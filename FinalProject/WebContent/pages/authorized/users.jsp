<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>users page - authorized user</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/users.css" %>
	<%@include file="/js/home-authorized.js" %>
	
</head>
<body>
<div class="container-fluids">

	<%@include file="/pageelements/navbarright.jsp" %>
	

	 
	<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
	<div class="row-fluid">
	<br>
		<form class="form-horizontal">
			<fieldset>
			
			<!-- Form Name -->
			
			
			
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="location">Keyword</label>  
			  <div class="col-md-4">
			  <input id="location" name="keyword" type="text" placeholder="name, surname..." class="form-control input-md">
			  
			  <span class="help-block">For example: Akezhan, etc.</span>  
			  </div>
			</div>
			
			
			
			
			<!-- Button -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="submit"></label>
			  <div class="col-md-4">
			    <button id="submit" name="submit" class="btn btn-primary">Search</button>
			  </div>
			</div>
			
			</fieldset>
		</form>			
	</div>
	
	<h2>Handmakers</h2>
	<c:forEach items="${users}" var="user">
		<div class="row-fluid users-container">
		    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " >
                  <div class="col-sm-6 col-md-6">
                  	  <img alt="" src="<c:out value="${user.imagepath}"/>">
                      <h4><c:out value="${user.name}"/> <c:out value="${user.surname}"/></h4>
                      <small>
                      <cite title="address">
                       <c:out value="${user.address}"/>, 
                       <c:out value="${user.city}"/>, 
                       Kazakhstan <i class="glyphicon glyphicon-map-marker"></i>
                      </cite>
                      </small>
                      
                  </div>
                  <div class="col-sm-6 col-md-6">
                      <div class="btn-group">
                          <c:if test="${user.isadmin==true}">
                          <form action="users" method="post">
                          	<input type="hidden" name="action" value="admin">
                          	<input type="hidden" name="value" value="0">
                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
                          	<input type="submit" class="btn btn-info" value="ADMIN">
                          	 
                          </form>
                       
	                   </c:if>
	                   <c:if test="${user.isadmin==false}">
	                       <form action="users" method="post">
	                          	<input type="hidden" name="action" value="admin">
	                          	<input type="hidden" name="value" value="1">
	                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
	                          	<input type="submit" class="btn btn-default" value="NOT ADMIN">
	                          	 
	                          </form>
	                   </c:if>
	                         <c:if test="${user.isright==true}">
	                       <form action="users" method="post">
	                          	<input type="hidden" name="action" value="right">
	                          	<input type="hidden" name="value" value="0">
	                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
	                          	<input type="submit" class="btn btn-success" value="RIGHT">
	                          	 
	                          	</form>
	                   </c:if>
	                   <c:if test="${user.isright==false}">
	                       <form action="users" method="post">
	                          	<input type="hidden" name="action" value="right">
	                          	<input type="hidden" name="value" value="1">
	                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
	                          	<input type="submit" class="btn btn-danger" value="NOT RIGHT">
	                          	 
	                          	</form>
	                   </c:if>
	                   <c:if test="${user.isdeleted==true}">
	                       <form action="users" method="post">
	                          	<input type="hidden" name="action" value="delete">
	                          	<input type="hidden" name="value" value="0">
	                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
	                          	<input type="submit" class="btn btn-danger" value="DELETED">
	                          	 
	                          	</form>
	                   </c:if>
	                   <c:if test="${user.isdeleted==false}">
	                       <form action="users" method="post">
	                          	<input type="hidden" name="action" value="delete">
	                          	<input type="hidden" name="value" value="1">
	                          	<input type="hidden" name="id"  value="<c:out value="${user.id}"/>">
	                          	<input type="submit" class="btn btn-success" value="NOT DELETED">
	                          	 
	                          	</form>
	                   </c:if>
                      </div>
                  </div>
		    </div>
		</div>
	</c:forEach>
</div>
	
</div>
</body>
</html>

<% } %>