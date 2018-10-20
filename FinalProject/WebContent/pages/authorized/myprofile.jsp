<%if(!request.getSession().getAttribute("userN").equals("") && !request.getSession().getAttribute("userI").equals("")){ %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<title>My Profile</title>
	<%@include file="/pageelements/headerelements.jsp" %>
	<%@include file="/css/myprofile.css" %>
	<%@include file="/js/myprofile.js" %>
	
</head>
<body>
	<div class="container-fluids">
		<%@include file="/pageelements/navbarright.jsp" %>
		
		
	    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
		
			<%@include file="subpages/myprofile.profile.jsp" %>
			
			<%@include file="subpages/myprofile.addhandmakeform.jsp" %>

			 
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<p class="handmakersworks">handmaker's works</p>
				<c:forEach items="${items}" var="item">
					<div class="item-block">
						<div class="row">
						    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" >
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
						    
					    </div>
					    <div class="edit">
					    	<button class="mybtn btn btn-warning btn-block" data-toggle="modal" data-target="#id<c:out value="${item.id}"/>" class="btn btn-primary center-block">
					    		<span class="glyphicon glyphicon-pencil">
								</span>
								Edit
                 			</button>
				    	</div>
					    <div class="delete">
				    		<form action="item" method="post">
				    			<input type="hidden" name="action" value="delete">
				    			<input type="hidden" name="item_id"  value="${item.id }" />
					    		<input type="submit" value="DELETE" id="button" class="btn">
				    		</form>
				    	</div>
				    </div>
				    
				    
				    
<!-- line modal -->
<div class="modal fade" id="id<c:out value="${item.id}"/>" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel">Edit Modal</h3>
		</div>
		<form action="edit2" method="post" enctype="multipart/form-data">
		<div class="modal-body">
			
            <!-- content goes here -->
			<div class="panel-body form-horizontal payment-form">
				<input type="hidden" name="id"  value="<c:out value="${item.id}"/>">
              	<div class="form-group files">
					<input  id="3"   type="file" name="image3" >
   					<img id="avatar3" src="<c:out value="${item.imagepath}"/>" alt="3"  width="90%" height="auto"/>
	  			</div>
                  <div class="form-group">
                      <label for="concept" class="col-sm-3 control-label">Name</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="concept" name="name" required value="<c:out value="${item.name}"/>">
                      </div>
                  </div>
                  <div class="form-group">
                      <label for="description" class="col-sm-3 control-label">Description</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="description" name="description" required value="<c:out value="${item.description}"/>">
                      </div>
                  </div>
                  <div class="form-group">
                      <label for="amount" class="col-sm-3 control-label">Amount</label>
                      <div class="col-sm-9">
                          <input name="amount" type="number" value="1" min="1" max="1000000" class="form-control" id="amount" required value="<c:out value="${item.amount}"/>">
                      </div>
                  </div> 
                  <div class="form-group">
                      <label for="amount" class="col-sm-3 control-label">Price</label>
                      <div class="col-sm-9">
                      	<div class="input-group"> 
			       		<span class="input-group-addon">&#8376;</span>
			        	<input name="price" type="number" value="0" min="0" class="form-control currency" required value="<c:out value="${item.price}"/>"/>
			    	</div>	
                     	</div>
                  </div>
                  <div class="form-group">
                      <label for="status" class="col-sm-3 control-label">Category name</label>
                      <div class="col-sm-9">
                          <select class="form-control" id="status" name="categorynameselect" onchange="OtherCategory2(this.value)" required>
                              <option value="">...select...</option>
                              <c:forEach items="${categories}" var="category"> 
                              	
                              	<c:set var="categoryname"><c:out value="${category.name}" /></c:set>
                              	<c:if test="${item.categoryname==categoryname}">
	              					<option value="<c:out value="${category.name}"/>" selected><c:out value="${category.name}"/></option>
	              				</c:if>
	              				<c:if test="${item.categoryname!=categoryname}">
	              					<option value="<c:out value="${category.name}"/>"><c:out value="${category.name}"/></option>
	              				</c:if>
                              
                              </c:forEach>
                              <option value="other">other</option>
                          </select>
                      </div>
                  </div> 
                  
                  <div class="form-group" id="OtherCategory2">
                      <label for="concept" class="col-sm-3 control-label">Category name</label>
                      <div class="col-sm-9">
                          <input type="text" class="form-control" id="concept" name="categorynameinput">
                      </div>
                  </div> 
                  
              </div>
		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				<div class="btn-group" role="group">
					<button type="submit" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
				</div>
			</div>
		</div>
		</form>
	</div>
  </div>
</div>
			  	</c:forEach>
			</div>
		
		</div> 
	</div>		
</body>
</html>
<% } %>