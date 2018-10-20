<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>item page - authorized</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/item-authorized.css" %>
	<%@include file="/js/item-authorized.js" %>
	
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
		
			<c:forEach items="${items}" var="item">
			
			<div class="item-block">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="item-block-navigation">
						<a href="/FinalProject/home">Store</a> -> <c:out value="${item.name}"/>
					</div>
				</div>
			</div>
			<div class="row">
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" >
			    	<div class="item-block-image">
			    		<img src="<c:out value="${item.imagepath}"/>">
			    	</div>
			    </div>
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			    	<div class="item-block-info">
			    		
			    		<p class="item-title">item information:</p>
			    		<p class="name"><c:out value="${item.name}"/></p>
			    		<p class="description"><c:out value="${item.description }"/></p>
			    		<p class="date"><c:out value="${item.date }"/></p>
			    		<p class="price">price. <c:out value="${item.price }"/> &#8376;</p>
			    		<p class="amount">amount. <c:out value="${item.amount }"/></p>
			    			    		
			    	</div>
			    </div>
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			    	<div class="item-block-info">
			    		<p class="handmaker-title">handmaker:</p>
			    		<p class="user-name"><a href='/FinalProject/profile?user_id=<c:out value="${item.user_id }"/>'><c:out value="${item.user_name }"/></a></p>
			    	</div>
			    </div>
		    </div>
		    <div class="go-to-buy">
	    		<form action="item" method="get">
	    			<input type="hidden" name="action" value="GoToBuy">
	    			<input type="hidden" name="item_id" value="<c:out value="${item.id}"/>" id="id">
		    		<input type="submit" value="GO TO BUY" id="button" class="btn">
	    		</form>
	    	</div>
		    </div>
		  	</c:forEach>
	  	
	</div>

</div>
</body>
</html>

<% } %>