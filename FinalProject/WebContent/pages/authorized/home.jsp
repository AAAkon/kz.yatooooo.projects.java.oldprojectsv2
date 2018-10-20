<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>home page - authorized user</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/home-authorized.css" %>
	<%@include file="/js/home-authorized.js" %>
	
</head>
<body>
<div class="container-fluids">

	<%@include file="/pageelements/navbarright.jsp" %>
	
	<%--  BASKET BLOCK
	<div id="basket-block">
		<form>
			<span id="count"><%=request.getSession().getAttribute("item-count-in-basket") %></span>
			<span id="title">basket</span>
			<img src="images/other/basket.png" alt="basket image">
		</form>
	</div>
	 --%>
	 
	<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
	<div class="row-fluid">
	<br>
		<form class="form-horizontal">
			<fieldset>
			
			<!-- Form Name -->
			
			
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="radius">Category name</label>
			  <div class="col-md-4">
			    <select id="radius" class="form-control" name="categoryname">
				    <option value="">NOTHING</option>
				    <c:forEach items="${categories }" var="category">
				      <option value='<c:out value="${category.name}"/>'><c:out value="${category.name}"/></option>
				    </c:forEach>
			    </select>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="location">Keyword</label>  
			  <div class="col-md-4">
			  <input id="location" name="keyword" type="text" placeholder="handmake name, description..." class="form-control input-md">
			  
			  <span class="help-block">For example: Nike, etc.</span>  
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
	<div class="row-fluid">
		<div id="items-container">
			<c:forEach items="${items}" var="item">
			<c:if test="${item.amount>0}">
		    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
		    	<div class="item-block" onclick="form_submit(<c:out value="${item.id}"/>)">
		    		
		    		<img src="<c:out value="${item.imagepath}"/>" >
		    		
		    		<div class="item-block-text">
		    			<p class="item-block-text-name"><c:out value="${item.name}"/></p>
		    			<p><c:out value="${item.price }"/> &#8376;</p>
		    			
		    		</div>
		    		<p class="item-block-text-handmaker"><c:out value="${item.user_name}"/></p>
		    	</div>
		    </div>
		    </c:if>
		  	</c:forEach>
	  	</div>
	</div>
	</div>
	
	<form id="item-form" action="item" method="get">
		<input type="text" name="action" value="details">
		<input id="item-id" type="text" name="item_id">
	</form>
	
</div>
</body>
</html>

<% } %>