<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>item-buy page - authorized</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/item-buy-authorized.css" %>
	<%@include file="/js/item-buy-authorized.js" %>
	
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
						<a href="/FinalProject/home">Store</a> -> <a href="/FinalProject/item?action=details&item_id=<c:out value="${item.id}"/>" ><c:out value="${item.name}"/></a> -> BUY FORM
					</div>
				</div>
			</div>
			<div class="row">
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			    	<div class="item-block-info">
			    		
			    		<p class="item-title">item information:</p>
			    		<p class="name"><c:out value="${item.name}"/></p>
			    		<p class="description"><c:out value="${item.description }"/></p>
			    		<p class="price">price. <c:out value="${item.price }"/> &#8376;</p>
			    		<p class="amount">amount. <c:out value="${item.amount }"/></p>
			    			    		
			    	</div>
			    </div>
			    <form action="item?action=buy" method="post">
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" >
			    	
		    			<input type="hidden" name="id" value="<c:out value="${item.id}"/>" id="id">
		    			<input type="hidden" name="price" value="<c:out value="${item.price}"/>" id="price">
		    			<input type="hidden" name="max-amount" value="<c:out value="${item.amount}"/>" id="price">
		    		
	    		    
	    		    <div class="container-fluids">
						<div class="row-fluid">
					        <fieldset>
					          <div id="legend">
					            <legend class="payment-title">Payment - item information</legend>
					          </div>
					     
					          <!-- Name -->
					          <div class="control-group">
					            <label class="control-label"  for="username">Item amount</label>
					            <div class="controls">
					              <input oninput="ChangePrice(this.value,<c:out value="${item.price }"/>)" type="number" min="1" max="<c:out value="${item.amount }"/>" name="amount" value="1" id="amount">
					            </div>
					          </div>
					     	  <br>
					          <!-- Card Number -->
					          <div class="control-group">
					            <label class="control-label" for="email">Price</label>
					            <div class="controls">
					            	<p id="purchase-price"><c:out value="${item.price }"/> &#8376;</p>
					            </div>
					          </div>
					     
					          
					        </fieldset>
					    </div>
					</div>
			    </div>
			    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
			    	<div class="container-fluids">
						<div class="row-fluid">
					        <fieldset>
					          <div id="legend">
					            <legend class="payment-title">Payment - card information</legend>
					          </div>
					     
					          <!-- Name -->
					          <div class="control-group">
					            <label class="control-label"  for="username">Card Holder's Name</label>
					            <div class="controls">
					              <input type="text" id="username" name="username" placeholder="" class="input-xlarge" required>
					            </div>
					          </div>
					     
					          <!-- Card Number -->
					          <div class="control-group">
					            <label class="control-label" for="email">Card Number</label>
					            <div class="controls">
					              <input type="text" id="email" name="email" placeholder="" class="input-xlarge" required>
					            </div>
					          </div>
					     
					          <!-- Expiry-->
					          <div class="control-group">
					            <label class="control-label" for="password">Card Expiry Date</label>
					            <div class="controls">
					              <select class="span3" name="expiry_month" id="expiry_month" required>
					                <option></option>
					                <option value="01">Jan (01)</option>
					                <option value="02">Feb (02)</option>
					                <option value="03">Mar (03)</option>
					                <option value="04">Apr (04)</option>
					                <option value="05">May (05)</option>
					                <option value="06">June (06)</option>
					                <option value="07">July (07)</option>
					                <option value="08">Aug (08)</option>
					                <option value="09">Sep (09)</option>
					                <option value="10">Oct (10)</option>1
					                <option value="11">Nov (11)</option>
					                <option value="12">Dec (12)</option>
					              </select>
					              <select class="span2" name="expiry_year">
					                <option value="13">2013</option>
					                <option value="14">2014</option>
					                <option value="15">2015</option>
					                <option value="16">2016</option>
					                <option value="17">2017</option>
					                <option value="18">2018</option>
					                <option value="19">2019</option>
					                <option value="20">2020</option>
					                <option value="21">2021</option>
					                <option value="22">2022</option>
					                <option value="23">2023</option>
					              </select>
					            </div>
					          </div>
					     
					          <!-- CVV -->
					          <div class="control-group">
					            <label class="control-label"  for="password_confirm">Card CVV</label>
					            <div class="controls">
					              <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="span2" required>
					            </div>
					          </div>
					     	  <br>
					          <!-- Submit -->
					          <div class="control-group">
					            <div class="controls">
					              <button class="btn btn-success">Pay Now</button>
					            </div>
					          </div>
					     
					        </fieldset>
					    </div>
					</div>
			    </div>
			    </form>
		    </div>
		    </div>
		    
		  	</c:forEach>
	  	
	</div>

</div>
</body>
</html>

<% } %>